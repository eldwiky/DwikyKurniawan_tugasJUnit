package com.qa.main;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qa.main.function.HitungFunction;

public class TestingKecepatan {

	HitungFunction function;
	@Before
	public void setUp() throws Exception {
	
		function = new HitungFunction();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHitungKecepatan() {
		for (String isi : readFile("kecepatan.csv")) {
			String[] data = isi.split(",");
			
			String jarak = data[0];
			String waktu = data[1];
			String jawab = data[2];
			System.out.println(jarak + waktu);

			assertEquals(Double.parseDouble(jawab), function.hitungKecepatan(Double.parseDouble(jarak), Double.parseDouble(waktu)),0.0000000000000000000000000000000000);
		}
	}
	
	@Test
	public void testHitungKecepatan2() {
		assertEquals("a", function.hitungKecepatan("a", "a"),0.0);
	}
	
	@Test
	public void testHitungKecepatan3() {
		assertEquals(50, function.hitungKecepatan(-100, -2), 0.0);
	}
	
	
	@Test
	public void testHitungKecepatan4() {
		assertEquals(function.hitungKecepatan(), 0.0);
	}
	
	public List<String> readFile(String namafile) {
		
		List<String> penampung = new ArrayList<String>();
		try {
			
			InputStream myFile = getClass().getClassLoader().getResourceAsStream(namafile);
			Scanner reader = new Scanner (myFile);
			
			while(reader.hasNextLine()) {
				penampung.add(reader.nextLine());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return penampung;
	}

}
