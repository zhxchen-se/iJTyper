package java.gwt;

import java.text.SimpleDateFormat;
import java.util.Date;
public class gt8 {
        public Date parse(String dateString){
            try{
                return (new SimpleDateFormat("yyyyMMdd")).parse(dateString);
            }catch(Exception ex){
                throw new IllegalArgumentException("Cannot convert to date: "+ dateString);
            }
        }
 }
