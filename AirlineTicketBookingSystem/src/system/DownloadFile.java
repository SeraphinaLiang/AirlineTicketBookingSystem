package system;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import main.Main;

public class DownloadFile {

	public static void collectForm(String filePath, String pass, String flightNo, String ticketNo) {
		try {
			File file = new File(filePath);
			file.createNewFile();
			Document doc = new Document();
			doc.setMargins(30, 30, 30, 30);
			PdfWriter.getInstance(doc, new FileOutputStream(file));
			doc.open();
			// ---------------------------------------------------------------------------
			SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
			sdf.applyPattern("yyyy-MM-dd");
			Date date = new Date();// 获取当前时间

			Flight f = Main.sql.getFlightPickByCustomer(flightNo);
			Ticket t = Main.sql.getTicketFromTicketNo(ticketNo);
			Passenger p = Main.sql.getPassengerFromPassportNo(pass);
			String seat = Main.sql.getSeatifAlreadyChoose(flightNo, pass);
			String gender = null;
			if (p.getGender() == 1) {
				gender = "MALE";
			} else {
				gender = "FEMALE";
			}

			// ---------------------------------------------------------------------------
			String s0 = "*****************************************************************************************************************\n";
			String s1 = "                                                                     ITINERARY\n";
			String s2 = "    TICKETNO: " + ticketNo + "                                        \n";
			String s3 = "    NAME:" + p.getFirstName() + "/" + p.getLastName() + "                    GENDER:" + gender
					+ "\n";
			String s4 = "    ID NUMBER: PP" + pass + "\n";
			String s5 = "    ISSUING AIRLINE : STAR AIRLINES                          DATE OF ISSUE: "
					+ sdf.format(date) + "\n";
			String s6 = "    ISSUING AGENT:\n";
			String s7 = "    AGENCY ADDRESS:\n";
			String s8 = "    TEL:                                           FAX:\n\n";
			String s9 = "    ________________________________________________________________________________\n";
			String s10 = "   ORIGIN/DES            FLIGHT            CLASS              DATE         TIME                    ARRTIME       \n";
			String s11 = "   -----------------------------------------------------------------------------------------------------------------------------------\n";
			String s12 = "   " + f.getDepartureCity() + "/" + f.getArrivalCity() + "   " + f.getNumber() + "          "
					+ t.getTheClass() + "            " + f.getDepartureDay() + " "
					+ f.getDepartureTime().substring(0, 5) + "         " + f.getArrivalDay() + " "
					+ f.getArrivalTime().substring(0, 5) + "\n";
			String s13 = "   ________________________________________________________________________________\n";
			String s14 = "   STATUS             ALLOW/ADD                           SEAT           TERMINAL(Takeoff/Arrival)\n";
			String s15 = "   -----------------------------------------------------------------------------------------------------------------------------------\n";
			String s16 = "    OK                " + t.getBaggageAllowance() + "/" + t.getBaggageAdd() + "          "
					+ seat + "          " + f.getT1() + "/" + f.getT2() + "\n";
			String s17 = "   ________________________________________________________________________________\n\n";
			String s18 = "   FARE CALCULATION: \n";
			String s19 = "                               TAX: " + t.tax + ".00 EUR\n";
			String s20 = "                               FARE: " + t.fare + ".00 EUR\n";
			String s21 = "                               TOTAL: " + t.total + ".00 EUR\n";
			String s22 = "   PAYMENT: ONLINE              \n\n ";
			String s23 = "*****************************************************************************************************************\n";

			Paragraph paragraph = new Paragraph(s0 + s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9 + s10 + s11 + s12 + s13
					+ s14 + s15 + s16 + s17 + s18 + s19 + s20 + s21 + s22 + s23);
			doc.add(paragraph);

			doc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void bill(String filePath, String pass, String flightNo, String ticketNo) {

		try {
			File file = new File(filePath);
			file.createNewFile();
			Document doc = new Document();
			doc.setMargins(30, 30, 30, 30);
			PdfWriter.getInstance(doc, new FileOutputStream(file));
			doc.open();

			SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
			sdf.applyPattern("yyyy-MM-dd");
			Date date = new Date();// 获取当前时间

			Flight f = Main.sql.getFlightPickByCustomer(flightNo);
			Ticket t = Main.sql.getTicketFromTicketNo(ticketNo);
			Passenger p = Main.sql.getPassengerFromPassportNo(pass);

			String gender = null;
			if (p.getGender() == 1) {
				gender = "MALE";
			} else {
				gender = "FEMALE";
			}

			String s0 = "*****************************************************************************************************************\n";
			String s1 = "                                                                     PAYMENT\n";
			String s2 = "    TICKETNO: " + ticketNo + "                                        \n";
			String s3 = "    NAME:" + p.getFirstName() + "/" + p.getLastName() + "                    GENDER:" + gender
					+ "\n";
			String s4 = "    ID NUMBER: PP" + pass + "\n";
			String s5 = "    ISSUING AIRLINE : STAR AIRLINES                          DATE OF ISSUE: "
					+ sdf.format(date) + "\n";

			String s6 = "   FARE CALCULATION: \n";
			String s7 = "                               TAX: " + t.tax + ".00 EUR\n";
			String s8 = "                               FARE: " + t.fare + ".00 EUR\n";
			String s9 = "                               TOTAL: " + t.total + ".00 EUR\n\n";
			String s10 = "   PAYMENT STATUS: " + Main.sql.ifpaid(ticketNo) + "             \n\n ";
			String s11 = "*****************************************************************************************************************\n";

			Paragraph paragraph = new Paragraph(s0 + s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9 + s10 + s11);
			doc.add(paragraph);

			doc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
