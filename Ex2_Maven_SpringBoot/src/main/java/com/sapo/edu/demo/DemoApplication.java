package com.sapo.edu.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.apache.commons.lang3.StringUtils.*;
import static org.springframework.util.CollectionUtils.containsAny;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private String nameUser;
	public DemoApplication(){
		
	}
	public String getNameUser(){
		return nameUser;
	}
	public void setNameUser(String name){
		this.nameUser=name;
	}

	public static void menu(){
		System.out.println("Nhap tuy chon cua ban");
		System.out.println("1. containsAny");
		System.out.println("2. containsIgnoreCase");
		System.out.println("3. countMatches");
		System.out.println("4. appendIfMissing");
		System.out.println("5. prependIfMissing");
		System.out.println("6. uppercase");
		System.out.println("7. lowercase");
	}
	public static boolean check(String chose){
		try{
			Integer.parseInt(chose);
			return true;
		}catch (NumberFormatException ex){
			return false;
		}
	}
	public static void xuLi(int c){
		Scanner scanner = new Scanner(System.in);
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		if(c == 1){
			//contrainsAny se tra ve true neu trong 2 ArrayList co chung cac phan tu.
			//tra ve false neu khong tim thay phan tu giong nhau.
			System.out.println("Nhap so phan tu cua mang 1.");
			int n = scanner.nextInt();
			String dauVao;
			for(int i=0;i<=n;i++){
				System.out.println("Nhap phan tu " +i);
				list1.add(scanner.nextLine());
			}
			System.out.println("Nhap so phan tu cua mang 2.");
			int m = scanner.nextInt();
			for(int i=0;i<m;i++){
				System.out.println("Nhap phan tu " +i);
				list2.add(scanner.nextLine());
			}
			System.out.println("Mang 1 co chua phan tu trong mang 2 hay khong? " + containsAny(list1, list2));
		}else if(c==2){
			//containsIgnoreCase so sanh 2 chuoi xem chuoi thu 2 co nam trong chuoi 1 hay khong,
			// va khong phan biet chu hoa chu thuong
			System.out.println("Nhap chuoi 1");
			String x1 = scanner.nextLine();
			System.out.println("Nhap chuoi 2");
			String x2 = scanner.nextLine();
			System.out.println("Chuoi thu 2 co nam trong chuoi 1 hay khong? " + containsIgnoreCase(x1,x2));

		}else if(c==3){
			//countMatches(a,b) dem so ki tu b co trong a
			System.out.println("Nhap chuoi 1");
			String x1 = scanner.nextLine();
			System.out.println("Nhap ki tu 2");
			String x2 = scanner.nextLine();
			System.out.println("dem so ki tu 2 co trong chuoi 1: " + countMatches(x1,x2));
		}else if(c==4){
			//appendIfMissing(a, b) noi chuoi b vao cuoi chuoi a neu cuoi chuoi b khong co chua chuoi a
			System.out.println("Nhap chuoi 1");
			String x1 = scanner.nextLine();
			System.out.println("Nhap chuoi 2");
			String x2 = scanner.nextLine();
			System.out.println("Noi chuoi 2 vao cuoi chuoi 1 neu cuoi chuoi 1 khong chua chuoi 2: " + appendIfMissing(x1, x2));
			//System.out.println("appendIfMissing: " + appendIfMissing("trung bac", "nam"));
		}else if(c==5){
			//prependIfMissing(a, b, c) noi b vao dau a neu dau a khong chua b va c
			System.out.println("Nhap chuoi 1");
			String x1 = scanner.nextLine();
			System.out.println("Nhap chuoi 2");
			String x2 = scanner.nextLine();
			System.out.println("Nhap chuoi 3");
			String x3 = scanner.nextLine();
			System.out.println("prependIfMissing noi chuoi 2 vao dau chuoi 1 neu dau chuoi 1 khong chua chuoi 2 hoac chuoi 3: " + prependIfMissing(x1, x2, x3));
		}else if(c==6){
			//uppercase
			System.out.println("Nhap chuoi ");
			String x1 = scanner.nextLine();
			System.out.println("uppercase chuoi vua nhap: " + x1.toUpperCase());
		}else if(c==7){
			//lowercase
			System.out.println("Nhap chuoi ");
			String x1 = scanner.nextLine();
			System.out.println("lowerCase chuoi vua nhap: "+x1.toLowerCase());
		}
	}

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		String chose;
		do {
			menu();
			chose = scanner.nextLine();
		}while (check(chose) == false);
		int c = Integer.parseInt(chose);
		xuLi(c);


//

//		System.out.println("What your name?");
//		String name=null;
//		DemoApplication firstUser = new DemoApplication();
//
//		if (scanner.hasNext()) {
//			name = scanner.nextLine();
//		}
//		firstUser.setNameUser(name);
//		System.out.println("Hello "+ firstUser.getNameUser());
//		System.out.println();




//		List<String> list1 = new ArrayList<String>();
//		List<String> list2 = new ArrayList<String>();
//		list1.add("trung tran");
//		list1.add("nam");
//
//		list2.add("thang");
//		list2.add("Trung");
//		//contrainsAny se tra ve true neu trong 2 ArrayList co chung cac phan tu.
//		//tra ve false neu khong tim thay phan tu giong nhau.
//		if(containsAny(list1, list2)){
//			System.out.println("done");
//		}
//		//containsIgnoreCase so sanh 2 chuoi xem chuoi thu 2 co nam trong chuoi 1 hay khong,
//		// va khong phan biet chu hoa chu thuong
//		if(containsIgnoreCase(list1.get(0),list2.get(1))){
//			System.out.println("containsIgnoreCase");
//		}
//		//countMatches(a,b) dem so ki tu b co trong a
//		System.out.println("countMatches: " + countMatches(list1.get(0),"t"));
//		//appendIfMissing(a, b) noi chuoi b vao cuoi chuoi a neu cuoi chuoi b khong co chua chuoi a
//		System.out.println("appendIfMissing: " + appendIfMissing("trung nam", "nam"));
//		System.out.println("appendIfMissing: " + appendIfMissing("trung bac", "nam"));
//		//prependIfMissing(a, b, c)
//		System.out.println("prependIfMissing: " + prependIfMissing("trung nam", "a", "b"));
//		//uppercase
//		System.out.println("uppercase: " + "trung".toUpperCase());
//		//lowercase
//		System.out.println("lowerCase: "+"TRUNG".toLowerCase());

	}
}

//@RestControler
//@RequestMapping("/")
