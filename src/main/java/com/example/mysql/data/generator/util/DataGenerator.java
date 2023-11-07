package com.example.mysql.data.generator.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.mysql.data.generator.model.Information;
import com.example.mysql.data.generator.service.InformationService;

@Component
public class DataGenerator {

	@Autowired
	private InformationService infoService;
	
	
	public void generateData(Long count) {
		Date start = new Date();
		List<Information> informations = new ArrayList<Information>();
		
		for(int i=0; i<count; i++) {
			
			UUID id = UUID.randomUUID();
			String npwp = generateNpwp();
			String serialNumber = generateSn();
			String certificate = generateCertificate();
			
			
			Information info = new Information();
			info.setId(id.toString());
			info.setNpwp(npwp.toString().substring(0, 15));
			info.setSerialNumber(serialNumber.toString().substring(0, 22));
			info.setCertificate(certificate);
			info.setCreationDate(new Date());
			informations.add(info);
		}
		
		infoService.saveAll(informations);
		
		Date end = new Date();
		Long millis = end.getTime() - start.getTime();
		
		Long minute = TimeUnit.MILLISECONDS.toMinutes(millis);
		Long second = TimeUnit.MILLISECONDS.toSeconds(millis);
		System.out.println(String.format("%02d minute %02d second", minute, second));
		
	}
	
	public String generateSn() {
		
		
		
		int fullSnLength = 22;
		
		String prefix = "SN_";
		
		int length = fullSnLength - prefix.length();
		
		
		String serialNumber = "";
		String alphaNumeric = "abcdefghijklmnopqrstuvwxyz0123456789";
		
		StringBuilder sb = new StringBuilder(length);
		
		for(int i=0; i<length; i++) {
			int index = (int) (alphaNumeric.length() * Math.random());
			sb.append(alphaNumeric.charAt(index));
		}
		serialNumber = prefix + sb.toString();
		return serialNumber;
	}
	
	public String generateNpwp() {
		int length = 13;
		String npwp = "";
		String alphaNumeric = "0123456789";
		
		StringBuilder sb = new StringBuilder(length);
		
		for(int i=0; i<length; i++) {
			int index = (int) (alphaNumeric.length() * Math.random());
			sb.append(alphaNumeric.charAt(index));
		}
		npwp = sb.toString() + "000";
		return npwp;
	}
	
	public String generateCertificate() {
		String certificate = "-----BEGIN CERTIFICATE-----\r\n"
				+ "MIID3jCCAsagAwIBAgIBAjANBgkqhkiG9w0BAQsFADBmMS0wKwYDVQQDDCRQVC4g\r\n"
				+ "UHJpdnkgSWRlbnRpdGFzIERpZ2l0YWwgKFBSSTc2NikxEzARBgNVBAsMCkVudGVy\r\n"
				+ "cHJpc2UxEzARBgNVBAoMClByaXZ5SUQgUkExCzAJBgNVBAYTAklEMB4XDTIxMDYx\r\n"
				+ "MTA5MTIzM1oXDTIyMDYxMTA5MTIzM1owgeIxJjAkBgkqhkiG9w0BCQETF2FobWFk\r\n"
				+ "LnB1dHJhOTFAZ21haWwuY29tMR0wGwYDVQQKExRLZW1lbnRlcmlhbiBLZXVhbmdh\r\n"
				+ "bjEUMBIGA1UECBMLREtJIEpha2FydGExCzAJBgNVBAYTAklEMRowGAYDVQQDExFB\r\n"
				+ "SE1BRCBTVVJZQSBQVVRSQTEkMCIGA1UECxMbT3Rvcml0YXMgU2VydGlmaWthdCBE\r\n"
				+ "aWdpdGFsMSIwIAYDVQQLExlEaXJla3RvcmF0IEplbmRlcmFsIFBhamFrMRAwDgYD\r\n"
				+ "VQQHEwdKYWthcnRhMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAooNX\r\n"
				+ "iyo/pZjyyy4tEeB4AuIJ4FHiWIvvT6zFSttgRUYuGn8R8paIZEJ8OOwerIf5x8LM\r\n"
				+ "QKDG5mAJwIxSBkOcnf3MUbb/TUUtRvRwMGiBTb9GYjfBomC7ZVs5gY8R36QUOThp\r\n"
				+ "/5aU0HNu+buA3J7pVclsoorI6zAagKbmbAjUMXqqwCUQjVW9jPGkH/73+u4UR4+u\r\n"
				+ "12l1f0p6NxqBxUjLkvzmr7hTnjO54+7bnBBIZaqJewCLqpIAlw9VJUmlJGKbAqPr\r\n"
				+ "vK8QZB/rLsMoqiGt0Z2spacsauCp/f5jwh6yoWtp7VtWDyn/xmp5iZq4990gznAj\r\n"
				+ "9PyJZD+p/iDDj2R8DQIDAQABoxowGDAJBgNVHRMEAjAAMAsGA1UdDwQEAwIF4DAN\r\n"
				+ "BgkqhkiG9w0BAQsFAAOCAQEAzsH2Uj85rUNdSdtYN56UfWAudWwRP1U4G3ZrGDZD\r\n"
				+ "L9g9vvU/qYyD9tCzN8Aj2MzxUWkle6V1Hiwwcg5qfiSGafIJvu5hTgy62QmVRurX\r\n"
				+ "Ljrvgh9q81yQQGCopmbHZZ3ahgUAQM0V202k7Yni5UtA5P1UBg2fAUkRDpQmLg9k\r\n"
				+ "3OexYXe+tRxpftqHdjA3xe9v8sQniGiJ+CMsmct/vF5lhG9jYWKQPJCc3YJG0J6G\r\n"
				+ "NYVgdD2ztN9jbtdGEQKDZ3LOUyIBjOOY34EWHSVorMPei3U0HzO00cmh6u2kl9DM\r\n"
				+ "IcaSWrQ0LewiVr3/t23hFyibnp7uMLnRz6Jol/1/fTZKRg==";
		return certificate;
	}
}
