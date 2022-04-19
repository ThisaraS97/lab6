package com; 
import model.Item; 
//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 
//For JSON
import com.google.gson.*; 
//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 
@Path("/Items") 
public class ItemService 
{ 
 Item itemObj = new Item(); 

 @PUT
 @Path("/") 
 @Consumes(MediaType.APPLICATION_JSON) 
 @Produces(MediaType.TEXT_PLAIN) 
 public String updateItem(String itemData) 
 { 
 //Convert the input string to a JSON object 
  JsonObject itemObject = new JsonParser().parse(itemData).getAsJsonObject(); 
 //Read the values from the JSON object
  String itemID = itemObject.get("itemID").getAsString(); 
  String itemCode = itemObject.get("itemCode").getAsString(); 
  String itemName = itemObject.get("itemName").getAsString(); 
  String itemPrice = itemObject.get("itemPrice").getAsString(); 
  String itemDesc = itemObject.get("itemDesc").getAsString(); 
  String output = itemObj.updateItem(itemID, itemCode, itemName, itemPrice, itemDesc); 
 return output; 
 }
}
