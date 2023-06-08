import java.util.Base64; 
import java.io.File; 
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;

class  EncodeToBase64{

public static void main(String[] args){
    try {
   byte[] array = Files.readAllBytes(Paths.get(args[0]));
  

    Base64.Encoder encoder = Base64.getEncoder();
    //System.out.println( encoder.encodeToString(array));

    String str = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:v2=\"http://xmlns.oracle.com/oxp/service/v2\">\r\n   <soapenv:Header/>\r\n   <soapenv:Body>\r\n      <v2:uploadObject>\r\n         <v2:reportObjectAbsolutePathURL>/Custom/Chandu</v2:reportObjectAbsolutePathURL>\r\n         <v2:objectType>xdm</v2:objectType>\r\n         <v2:objectZippedData>"+encoder.encodeToString(array)+"</v2:objectZippedData>\r\n         <v2:userID>lisa.jones</v2:userID>\r\n         <v2:password>fUX3t#7?</v2:password>\r\n      </v2:uploadObject>\r\n   </soapenv:Body>\r\n</soapenv:Envelope>";
    BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
    writer.write(str);
     writer.close();
    }catch(Exception e){
        e.printStackTrace();

    }
    
}

}