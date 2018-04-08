package com.dbms.project.moovi.business.service;

import com.dbms.project.moovi.data.repository.MovieRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

@RestController
public class MovieService extends APICredentials {

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping(value = "/api/movie/{movieName}", method = RequestMethod.GET)
    public void getMovies(@PathVariable("movieName") String movieName) {
        String u = "https://api.themoviedb.org/3/search/movie?api_key="+apiKey+"&query="+movieName;
        try {
            URL url = new URL(u);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if(responseCode != 200)
                throw new RuntimeException("HttpResponseCode: " +responseCode);
            else
            {
                String inline = "";
                Scanner sc = new Scanner(url.openStream());
                while(sc.hasNext())
                {
                    inline += sc.nextLine();
                }
                System.out.println("\nJSON data in string format");
                System.out.println(inline);
                sc.close();
                JSONParser parse = new JSONParser();
                JSONObject jobj = (JSONObject)parse.parse(inline);
                JSONArray jsonarr_1 = (JSONArray) jobj.get("results");


                //Get data for Results array
                for(int i=0;i<jsonarr_1.size();i++)
                {
                    //Store the JSON objects in an array
                    //Get the index of the JSON object and print the values as per the index
                    JSONObject jsonobj_1 = (JSONObject)jsonarr_1.get(i);
                    //Store the JSON object in JSON array as objects (For level 2 array element i.e Address Components)
                    //JSONArray jsonarr_2 = (JSONArray) jsonobj_1.get("address_components");
                    //System.out.println("Elements under results array");
                    System.out.println("\nMovie id: " +jsonobj_1.get("id"));
                    System.out.println("Movie name: " +jsonobj_1.get("original_title"));
                    //Get data for the Address Components array
//                    System.out.println("Elements under address_components array");
//                    System.out.println("The long names, short names and types are:");
//                    for(int j=0;j<jsonarr_2.size();j++)
//                    {
//                        //Same just store the JSON objects in an array
//                        //Get the index of the JSON objects and print the values as per the index
//                        JSONObject jsonobj_2 = (JSONObject) jsonarr_2.get(j);
//                        //Store the data as String objects
//                        String str_data1 = (String) jsonobj_2.get("long_name");
//                        System.out.println(str_data1);
//                        String str_data2 = (String) jsonobj_2.get("short_name");
//                        System.out.println(str_data2);
//                        System.out.println(jsonobj_2.get("types"));
//                        System.out.println("\n");
//                    }
                }



            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
