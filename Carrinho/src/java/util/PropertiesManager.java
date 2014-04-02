/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author paddock
 */
public class PropertiesManager {
    
    private String fileName;
    
    /**
     * Metodo construtor. Seta o nome do arquivo de propriedades que será manipulado
     * @param fileName nome do arquivo a ser manipulado pela classe
     */
    public PropertiesManager(String fileName){
        this.fileName = fileName;
    }
    
    /**
     * Method responsible for creating the properties file
     * @param dados the data which is to be stored in the file
     * @throws IOException Exception when it is not possible to create the properties file.
     */
    public void createPropertiesFile(HashMap dados) throws IOException{
        Properties props = new Properties();
        Set valores = dados.entrySet();
        Iterator it = valores.iterator();
        while(it.hasNext()){
            Map.Entry me = (Map.Entry) it.next();
            String chave = (String) me.getKey();
            String valor = (String) me.getValue();
            props.setProperty(chave, valor);
        
            FileOutputStream out = new FileOutputStream(fileName);
            props.store(out, null);
            out.close();
        }
    }
    
    /**
     * This method read the properties file
     * @return collection of objects with the data file
     * @throws IOException exception generated in case of problem when reading the properties file
     */
    public HashMap readPropertiesFile() throws IOException   {
        Properties properties;
        StringTokenizer sToken;
        HashMap lista = new HashMap();
        int count=0;
        
        InputStream is = getClass().getResourceAsStream( fileName );
        properties = new Properties();
        properties.load( is );
        
        for (Enumeration list = properties.propertyNames(); list.hasMoreElements(); count++) {
            String entry = (String) list.nextElement();
            //System.out.println("entrada = " + entry);
            lista.put(entry, properties.getProperty(entry));
        }
        return lista;
    }
    
}
