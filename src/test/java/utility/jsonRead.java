package utility;

import entities.CreateHotelBooking;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class  jsonRead {

    public List<CreateHotelBooking> jsonDataRead() throws IOException, ParseException {
        List<CreateHotelBooking> createHotelBookingList = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src/test/requestData/hotelBookingRequestData.json");
        Object obj = jsonParser.parse(fileReader);
        JSONArray hotelBookingJsonArray = (JSONArray) obj;
        for (int i = 0; i < hotelBookingJsonArray.size(); i++) {
            JSONObject hotelBookingObj = (JSONObject) hotelBookingJsonArray.get(i);

            String jsonfirstname = (String) hotelBookingObj.get("firstname");
            String jsonsurname = (String) hotelBookingObj.get("surname");
            String jsonprice = (String) hotelBookingObj.get("price");
            String jsondeposit = (String) hotelBookingObj.get("deposit");
            String jsoncheckIn = (String) hotelBookingObj.get("checkIn");
            String jsoncheckOut = (String) hotelBookingObj.get("checkOut");
            CreateHotelBooking hotelBooking = new CreateHotelBooking(jsonfirstname, jsonsurname, jsonprice, jsondeposit, jsoncheckIn, jsoncheckOut);
            createHotelBookingList.add(hotelBooking);
        }
         return createHotelBookingList;
    }


}
