package com.project.rest.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

import com.project.rest.entity.Call;

@Service
public class CallService {
	
	int callDurationByDay[] = new int[7];
	int callDurationByHour[] = new int[24];
	int callStartAtByDay[] = new int[7];
	int callStartAtByHour[] = new int[24];
	
	String WeekDays[] = {"Monday","Tuesday","Wednesday","Thursday",
						 "Friday","Saturday","Sunday"};
	
	CallService() {
		clearPrevious();
	}
	
	String Hour_(int hours) {
		if(hours>12) return ((hours%12)+" PM");
		if(hours==0) return "12 AM";
		return hours+" AM ";
	}
	
	String Day_(int day) {
		return WeekDays[day];
	}
	
	public String getDetails(List<Call> calls) throws ParseException {
		clearPrevious();
		for(Call call:calls) {
			String sDate=call.Start_time;
	        Date date=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(sDate);
			callDurationByDay[date.getDay()]+=call.Duration;
			callStartAtByDay[date.getDay()]++;
			callDurationByHour[date.getHours()]+=call.Duration;
			callStartAtByHour[date.getHours()]++;
		}
		
		String maxDetails = "Hour of the day when the Call Duration is Highest is " + 
				          findMaxHour(callDurationByHour) + "\n" +
				          "Day of the Week when the Call Duration is Highest is " +
				          findMaxDay(callDurationByDay) + "\n" +
		        		  "Hour of the day when the Call Volume is Highest is " + 
				          findMaxHour(callStartAtByHour) + "\n" +
				          "Day of the Week when the Call Volume is Highest is " +
				          findMaxDay(callStartAtByDay) + "\n";
		
		String minDetails = "Hour of the day when the Call Duration is Lowest is " + 
							findMinHour(callDurationByHour) + "\n" +
				          "Day of the Week when the Call Duration is Lowest is " +
				          findMinDay(callDurationByDay) + "\n" +
				          "Hour of the day when the Call Volume is Lowest is " + 
				          findMinHour(callStartAtByHour) + "\n" +
				          "Day of the Week when the Call Volume is Lowest is " +
				          findMinDay(callStartAtByDay) + "\n";
		
		return maxDetails + "\n" + minDetails;
//		String details = " " +
//				"Hour of the day when the call volume is highest is 6-7 AM";
//		return details;
		
	}
	
	void clearPrevious(){
		for(int i=0;i<7;i++) {
			callDurationByDay[i]=0;
			callStartAtByDay[i]=0;
		}
		for(int i=0;i<24;i++) {
			callDurationByHour[i] = 0;
			callStartAtByHour[i] = 0;
		}
	}
	
	String findMaxDay(int dayCount[]) {
		int maxCount = dayCount[0], maxCountDay=0;
		for(int i=1;i<7;i++) {
			if(dayCount[i]>maxCount) {
				maxCount = dayCount[i];
				maxCountDay = i;
			}
		} return Day_(maxCountDay);
	}
	
	String findMaxHour(int hourCount[]) {
		int maxCount = hourCount[0], maxCountHour=0;
		for(int i=1;i<24;i++) {
			if(hourCount[i]>maxCount) {
				maxCount = hourCount[i];
				maxCountHour = i;
			}
		} return Hour_(maxCountHour) + " - " + Hour_(maxCountHour+1) ;
	}
	
	String findMinDay(int dayCount[]) {
		int minCount = dayCount[0], minCountDay=0;
		for(int i=1;i<7;i++) {
			if(dayCount[i]<minCount) {
				minCount = dayCount[i];
				minCountDay = i;
			}
		} return Day_(minCountDay);
	}
	
	String findMinHour(int hourCount[]) {
		int minCount = hourCount[0], minCountHour=0;
		for(int i=1;i<24;i++) {
			if(hourCount[i]<minCount) {
				minCount = hourCount[i];
				minCountHour = i;
			}
		} return Hour_(minCountHour) + " - " + Hour_(minCountHour+1) ;
	}
	
	
}
