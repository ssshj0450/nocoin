package com.example.user.a0911_2;

import android.os.AsyncTask;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.net.URL;
import java.util.ArrayList;

public class ManageEventData {
    private static ManageEventData manageEventData;

    EventData eventData;

    private ArrayList<EventData> eventDataArrayList;
    public ArrayList<EventData> freeEventArrayList;
    public ArrayList<EventData> concertEventArrayList;
    public ArrayList<EventData> experienceEventArrayList;
    public ArrayList<EventData> movieEventArrayList;
    public ArrayList<EventData> cultureEventArrayList;
    public ParseEventData parseEventData;

    String tag_name = null;
    boolean bSet = false;

    public static ManageEventData getInstance(){
        if(manageEventData == null){
            manageEventData = new ManageEventData();
        }
        return manageEventData;
    }

    private ManageEventData(){
        parseEventData = new ParseEventData();
        eventData = new EventData();
        eventDataArrayList = new ArrayList<EventData>(100);
        freeEventArrayList = new ArrayList<EventData>(100);
        concertEventArrayList = new ArrayList<EventData>(100);
        experienceEventArrayList = new ArrayList<EventData>(100);
        movieEventArrayList = new ArrayList<EventData>(100);
        cultureEventArrayList = new ArrayList<EventData>(100);
    }

    public ArrayList<EventData> getEventDataArrayList(){
        return eventDataArrayList;
    }

    public ArrayList<EventData> getFreeEventArrayList() {
        return freeEventArrayList;
    }
    public ArrayList<EventData>getConcertEventArrayList(){return concertEventArrayList;}
    public ArrayList<EventData>getExperienceEventArrayList(){return experienceEventArrayList;}
    public ArrayList<EventData>getMovieEventArrayList(){return movieEventArrayList;}
    public ArrayList<EventData>getCultureEventArrayList(){return cultureEventArrayList;}
    public void setEventDataArrayList(ArrayList<EventData> eventDataArrayList) {
        this.eventDataArrayList = eventDataArrayList;
    }
    public void setFreeEventArrayList(ArrayList<EventData> freeEventArrayList){
        this.freeEventArrayList = freeEventArrayList;
    }
    public void setConcertEventArrayList(ArrayList<EventData>concertEventArrayList){
        this.concertEventArrayList = concertEventArrayList;
    }
    public void setExperienceEventArrayList(ArrayList<EventData>experienceEventArrayList){
        this.experienceEventArrayList = experienceEventArrayList;
    }
    public void setMovieEventArrayList(ArrayList<EventData>movieEventArrayList){
        this.movieEventArrayList = movieEventArrayList;
    }
    public void setCultureEventArrayList(ArrayList<EventData>cultureEventArrayList){
        this.cultureEventArrayList = cultureEventArrayList;
    }
    public class ParseEventData extends AsyncTask<String,Integer,String> {
        boolean inCodeName = false,inTitle = false, inTIME = false, inPlace = false, inMAIN_IMG = false,inORG_Link = false,inIS_FREE = false;
        String codename = null,title = null, time = null, place = null, org_link =null, main_img = null, is_free = null;
        @Override
        protected String doInBackground(String...params){
            Log.v("test","들어옴");
            String url = "http://openapi.seoul.go.kr:8088/525a414f62676d6c36395053436a41/xml/SearchConcertDetailService/1/100/";
            XmlPullParserFactory factory;
            XmlPullParser parser;
            URL xmlUrl;
            String returnResult = " ";
            try{
                xmlUrl = new URL(url);
                xmlUrl.openConnection().getInputStream();
                factory = XmlPullParserFactory.newInstance();
                parser = factory.newPullParser();
                parser.setInput(xmlUrl.openStream(),null);
                int eventType = parser.getEventType();

                while(eventType != XmlPullParser.END_DOCUMENT){
                    switch (eventType){
                        case XmlPullParser.START_TAG:
                            if(parser.getName().equals("CODENAME"))
                            {
                                inCodeName = true;
                            }
                            if(parser.getName().equals("TITLE")){
                                inTitle = true;
                            }
                            if(parser.getName().equals("TIME")){
                                inTIME = true;
                            }
                            if(parser.getName().equals("PLACE")){
                                inPlace  = true;
                            }
                            if(parser.getName().equals("ORG_LINK")){
                                inORG_Link = true;
                            }
                            if(parser.getName().equals("MAIN_IMG")){
                                inMAIN_IMG = true;
                            }
                            if(parser.getName().equals("IS_FREE")){
                                inIS_FREE = true;
                            }
                            if(parser.getName().equals("message")){
                                Log.v("test","오류");
                            }
                            break;
                        case XmlPullParser.TEXT:
                            if(inCodeName){
                                codename=parser.getText();
                                eventData.setCodeName(codename);
                                inCodeName = false;
                            }
                            if(inTitle){
                                title = parser.getText();
                                eventData.setTitle(title);
                                Log.v("test","이름가져옴 : " + eventData.getTitle()+" / "+title);
                                inTitle = false;
                            }
                            if(inTIME){
                                time = parser.getText();
                                eventData.setDate(time);
                                Log.v("test","시간 가져옴");
                                inTIME = false;
                            }
                            if(inPlace){
                                place = parser.getText();
                                eventData.setPlace(place);
                                inPlace = false;
                            }
                            if(inMAIN_IMG){
                                main_img=parser.getText();
                                eventData.setImage(main_img);
                                Log.v("test","그림 가져옴 : "+eventData.getImage());
                                inMAIN_IMG = false;
                            }
                            if(inORG_Link){
                                org_link=parser.getText();
                                eventData.setOrigin(org_link);
                                inORG_Link = false;
                            }
                            if(inIS_FREE){
                                is_free=parser.getText();
                                eventData.setIsFree(is_free);
                                eventDataArrayList.add(new EventData(eventData.getCodeName(),eventData.getTitle(),eventData.getDate(),eventData.getPlace(),eventData.getIsFree(),eventData.getOrigin(),eventData.getImage()));
                                Log.v("test","행사 : "+eventDataArrayList.get(eventDataArrayList.size()-1).getTitle());
                                inIS_FREE = false;
                            }
                            break;
                        case XmlPullParser.END_TAG:
                            if(parser.getName().equals("row")){

                            }
                            break;
                    }
                    eventType = parser.next();
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }

            return "";
        }

        protected void onPostExecute(String result){
            super.onPostExecute(result);

            Log.v("test","끝단계 근데...");
            for(int i = 0;i<manageEventData.getEventDataArrayList().size();i++){
                EventData tmp = new EventData();
                tmp = eventDataArrayList.get(i);
                if(tmp.getIsFree().equals("1")) {
                    freeEventArrayList.add(new EventData(tmp.getCodeName(), tmp.getTitle(), tmp.getDate(), tmp.getPlace(), tmp.getIsFree(), tmp.getOrigin(), tmp.getImage()));
                    if(tmp.getCodeName().equals("클래식")||tmp.getCodeName().equals("콘서트")||tmp.getCodeName().equals("국악")||tmp.getCodeName().equals("뮤지컬/오페라")||tmp.getCodeName().equals("무용")||tmp.getCodeName().equals("독주/독창회")||tmp.getCodeName().equals("연극")||tmp.getCodeName().equals("전시/미술")){
                        concertEventArrayList.add(new EventData(tmp.getCodeName(), tmp.getTitle(), tmp.getDate(), tmp.getPlace(), tmp.getIsFree(), tmp.getOrigin(), tmp.getImage()));
                    }
                    if(tmp.getCodeName().equals("문화교양/강좌")){
                        cultureEventArrayList.add(new EventData(tmp.getCodeName(), tmp.getTitle(), tmp.getDate(), tmp.getPlace(), tmp.getIsFree(), tmp.getOrigin(), tmp.getImage()));
                    }
                    if(tmp.getCodeName().equals("기타")){
                        experienceEventArrayList.add(new EventData(tmp.getCodeName(), tmp.getTitle(), tmp.getDate(), tmp.getPlace(), tmp.getIsFree(), tmp.getOrigin(), tmp.getImage()));
                    }
                    if(tmp.getCodeName().equals("영화")){
                        movieEventArrayList.add(new EventData(tmp.getCodeName(), tmp.getTitle(), tmp.getDate(), tmp.getPlace(), tmp.getIsFree(), tmp.getOrigin(), tmp.getImage()));
                    }
                }
            }
        }

    }
}