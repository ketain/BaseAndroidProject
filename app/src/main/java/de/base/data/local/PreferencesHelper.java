package de.base.data.local;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import de.base.injection.ApplicationContext;


/**
 * Created by Sebastian Müller on 12.11.2016.
 */
public class PreferencesHelper {

    /**
     * Allows differentiation between two storage options.
     * Transient and persistent.
     * Generally transient data is deleted as soon as the
     * auth cooky is expired while persistent data is not.
     */
    private enum StorageMode{
        TRANSIENT,
        PERSISTENT;
    }

    private static final String COLLECTION_TYPE = "COLLECTION_TYPE";
    private static final String MAP_TYPE = "MAP_TYPE";


    private final ObjectMapper mapper;
    private final SharedPreferences transientPreferences;
    private final SharedPreferences perisistentPreferences;

    @Inject
    public PreferencesHelper(ObjectMapper mapper, @ApplicationContext Context context) {
        this.mapper = mapper;
        this.transientPreferences = context.getSharedPreferences("app_temp_pref_file" ,Context.MODE_PRIVATE);
        this.perisistentPreferences = context.getSharedPreferences("app_pers_pref_file" ,Context.MODE_PRIVATE);
    }

    /*************************************************************
     *           DATA PERSISTENCE LOGIC IMPLEMENTED HERE         *
     * ***********************************************************/

    /**
     * Removes the transient data from shared preferences.
     */
    @SuppressLint({"CommitPrefEdits", "ApplySharedPref"})
    public void clear(){
        transientPreferences.edit().clear().commit();
    }

    /**
     * Stores variables into the shared transientPreferences.
     * @param key the unique string key with which the data can be retrieved again.
     * @param obj object to be stored. method returns if this is null.
     */
    private void storeToStorage(@NonNull String key, Object obj, StorageMode mode){

        if(obj == null){
            return;
        }

        try {
            String value = mapper.writeValueAsString(obj);
            SharedPreferences.Editor editor;
            if(mode == StorageMode.TRANSIENT){
                editor = transientPreferences.edit();
            } else{
                editor = perisistentPreferences.edit();
            }

            editor.putString(key, value);
            editor.apply();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param key
     * @param type
     * @param <T>
     * @return
     */
    private <T> T retrieveFromStorage(String key, Class<T> type, StorageMode mode){
        T obj = null;

        try {
            String value;

            if(mode == StorageMode.TRANSIENT){
                value = transientPreferences.getString(key, null);
            } else{
                value = perisistentPreferences.getString(key, null);
            }

            if(value != null && type != String.class){
                obj = mapper.readValue(value, type);
            } else if(value != null && type == String.class){
                value = value.substring(1, value.length()-1); // remove quotation marks
                obj = (T) value;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * Method that retrieves complex objects with custom types from shared transientPreferences
     * @param key The key identifying the object within sharedPreferences
     * @param type technical parameter needed by the ObjectMapper. It is used to identify the method the mapper needs to call.
     *             Concrete: It specifies wether the returned type is a map or a collection. There a other methods but those
     *             2 are currently supported
     * @param returnType The type of the object this method is to return.
     * @param paramType list of parameters containing the typed generic returnType will be resolved with. Example: HashMap<paramType[0], paramType[1]>
     * @return the retrieved object of type returnType.
     */
    private <T> T retrieveComplexType(String key, StorageMode mode, String type, Class<T> returnType, Class ... paramType){
        T obj = null;

        try {
            String value;
            if(mode == StorageMode.TRANSIENT){
                value = transientPreferences.getString(key, null);
            } else{
                value = perisistentPreferences.getString(key, null);
            }
            if(value != null){
                TypeFactory typeFactory = mapper.getTypeFactory();
                switch (type){
                    case COLLECTION_TYPE:
                        CollectionLikeType collection = typeFactory.constructCollectionType(List.class, paramType[0]);
                        obj = mapper.readValue(value, collection);
                        break;
                    case MAP_TYPE:
                        MapLikeType map = typeFactory.constructMapType(Map.class, paramType[0], paramType[1]);
                        obj = mapper.readValue(value, map);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     *
     * @param key
     */
    private void removeFromStorage(String key){
        if(transientPreferences == null){
            return;
        }
        SharedPreferences.Editor editor = transientPreferences.edit();
        editor.remove(key);
        editor.apply();
    }


}
