import java.util.*;

public class Main {
	
	static Scanner scan = new Scanner(System.in);
	static Random rn = new Random();
	static ArrayList<Encap> arr = new ArrayList<>();
	int time=0;
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		int pilih=0;
		
		System.out.println("Selamat datang di PT. Mentol");
		
		do {
			System.out.println("<< Menu >>");
			System.out.println("1. Insert data karyawan");
			System.out.println("2. View data karyawan");
			System.out.println("3. Update data karyawan");
			System.out.println("4. Delete data karyawan");
			System.out.println("5. Exit");
			System.out.print(">> ");
			pilih = scan.nextInt();
			scan.nextLine();
			switch(pilih) {
			case 1:
				add();
				break;
			case 2:
				view();
				break;
			case 3:
				update();
				break;
			case 4:
				delete();
				break;
			case 5:
				System.out.println("Terima kasih telah mengunjungi PT. Mentol");
				break;
			default:
				System.out.println("Permintaan anda tidak diketahui");
				break;
			}
		} while(pilih!=5);
	}
	
	//Simpan hasil random id 2 huruf + '-' + 4 angka
	private static String addId() {
		int random=0;
		String id="";
		
		for(int i=1;i<=2;i++) {
			random = rn.nextInt(26) + 65;
			id = id + (char) random;
		}
		
		id = id + '-';
		
		for(int i=1;i<=4;i++) {
			random = rn.nextInt(10);
			id = id + random;
		}
		
		return id;
	}
	
	//Simpan nama yang >= 3 huruf
	private static String addNama() {
		int panjang=0;
		String nama="";
		
		do {
			System.out.print("Input nama karyawan [>=3]: ");
			nama = scan.nextLine();
			panjang = nama.length();
		} while(panjang<3);
		
		return nama;
	}
	
	//Simpan jenis kelamin Laki-laki atau Perempuan
	private static String addJenis() {
		String jenis="";
		
		do {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			jenis = scan.nextLine();
		} while(jenis.equals("Laki-laki")==false && jenis.equals("Perempuan")==false);
		
		return jenis;
	}
	
	//Simpan jabatan Manager atau Supervisor atau Admin
	private static String addJabatan() {
		String jabatan="";
		
		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			jabatan = scan.nextLine();
		} while(jabatan.equals("Manager")==false && jabatan.equals("Supervisor")==false && jabatan.equals("Admin")==false);
		
		return jabatan;
	}
	
	//Tentukan gaji berdasarkan jabatan
	private int addGaji(String jabatan) {
		int gaji=0;
		
		if(jabatan.equals("Manager")==true) {
			gaji = 8000000;
		}
		else if(jabatan.equals("Supervisor")==true) {
			gaji = 6000000;
		}
		else if(jabatan.equals("Admin")==true) {
			gaji = 4000000;
		}
		
		return gaji;
	}
	
	//Sort karyawan berdasarkan urutan masuknya
	private void sortTime() {
		Encap temp;
		
		for(int i=0;i<arr.size();i++) {
			for(int j=i+1;j<arr.size();j++) {
				if(arr.get(i).getTime()>arr.get(j).getTime()) {
					temp = arr.get(i);
					arr.set(i, arr.get(j));
					arr.set(j, temp);
				}
			}
		}
	}
	
	//Tentukan bonus karyawan berdasarkan urutan masuknya, bukan berdasarkan urutan nama
	private void addBonus(String jabatan) {
		sortTime();
		
		int manager=0, supervisor=0, admin=0;
		
		for(int i=0;i<arr.size();i++) {
			if(arr.get(i).getJabatan().equals("Manager")==true) {					
				manager++;
			}
			else if(arr.get(i).getJabatan().equals("Supervisor")==true) {			
				supervisor++;
			}
			else if(arr.get(i).getJabatan().equals("Admin")==true) {			
				admin++;
			}
		}
		
		int temp=0,temp2=0, temp3=0, o=3, p=3, q=3;
		temp = manager/3;
		temp2 = supervisor/3;
		temp3 = admin/3;
		
		if(jabatan.equals("Manager")==true) {
			//Loop berdasarkan banyaknya kelipatan 3
			for(int i=0;i<temp;i++) {
				//Jika jumlah Manager adalah kelipatan 3
				if(manager%3==0) {
					System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id ");
					int a=0;
					//Loop untuk mencari siapa saja yang merupakan Manager
					for(int j=0;j<arr.size();j++) {
						if(arr.get(j).getJabatan().equals("Manager")==true && a<o) {		
							arr.get(j).setGaji(arr.get(j).getGaji()+(arr.get(j).getGaji()*10/100));
							if(a!=o-1) {
								System.out.printf("%s, ",arr.get(j).getId());
							}
							else if(a==o-1) {
								System.out.printf("%s\n",arr.get(j).getId());
							}
							a++;
						}
					}
					o=o+3;
				}
			}
		}
		
		else if(jabatan.equals("Supervisor")==true) {
			for(int i=0;i<temp2;i++) {
				if(supervisor%3==0) {
					System.out.print("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id ");
					int b=0;
					for(int j=0;j<arr.size();j++) {
						if(arr.get(j).getJabatan().equals("Supervisor")==true && b<p) {
							arr.get(j).setGaji(arr.get(j).getGaji()+(arr.get(j).getGaji()*75/1000));
							if(b!=p-1) {
								System.out.printf("%s, ",arr.get(j).getId());
							}
							else if(b==p-1) {
								System.out.printf("%s\n",arr.get(j).getId());
							}
							b++;
						}
					}
					p=p+3;
				}
			}
		}
		
		else if(jabatan.equals("Admin")==true) {
			for(int i=0;i<temp3;i++) {
				if(admin%3==0) {
					System.out.print("Bonus sebesar 5% telah diberikan kepada karyawan dengan id ");
					int c=0;
					for(int j=0;j<arr.size();j++) {
						if(arr.get(j).getJabatan().equals("Admin")==true && c<q) {
							arr.get(j).setGaji(arr.get(j).getGaji()+(arr.get(j).getGaji()*5/100));
							if(c!=q-1) {
								System.out.printf("%s, ",arr.get(j).getId());
							}
							else if(c==q-1) {
								System.out.printf("%s\n",arr.get(j).getId());
							}
							c++;
						}
					}
					q=q+3;
				}
			}
		}
	}
	
	//Menampung enter sebagai tombol untuk return ke menu utama
	private void enter() {
		String input="";
		
		do {
			System.out.println("ENTER to return");
			input = scan.nextLine();
		} while(input.equals("")==false);
	}
	
	//Simpan semua data dalam Encapsulasi
	private void add() {
		String id=addId();
		String nama=addNama();
		String jenis=addJenis();
		String jabatan=addJabatan();
		
		System.out.printf("Berhasil menambahkan karyawan dengan id %s\n", id);
		
		int gaji=addGaji(jabatan);
		
		time++;
		
		Encap E = new Encap(id, nama, jenis, jabatan, gaji, time);
		arr.add(E);
		
		addBonus(jabatan);
		
		enter();
	}
	
	//Sort karyawan berdasarkan urutan namanya
	private void sortName() {
		Encap temp;
		
		for(int i=0;i<arr.size();i++) {
			for(int j=i+1;j<arr.size();j++) {
				if(arr.get(i).getNama().compareTo(arr.get(j).getNama()) > 0) {
					temp = arr.get(i);
					arr.set(i, arr.get(j));
					arr.set(j, temp);
				}
			}
		}
	}
	
	//Lihat dalam bentuk tabel
	private void view() {
		sortName();
		
		int gaji=0;
		
		System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
		System.out.println("|No  |Kode Karyawan    |Nama Karyawan                 |Jenis Kelamin  |Jabatan       |Gaji Karyawan|");
		System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
		
		for(int i=0;i<arr.size();i++) {
			gaji = (int) arr.get(i).getGaji();
			System.out.printf("|%4d|%17s|%30s|%15s|%14s|%13d|\n", i+1, arr.get(i).getId(), arr.get(i).getNama(), arr.get(i).getJenis(), arr.get(i).getJabatan(), gaji);
		}
		
		System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
		
		System.out.println("");
	}
	
	//Cek apakah kedua karakter didepan merupakan huruf kapital
	private static int cekHuruf(String id) {
		int huruf=0;
		
		for (int i=0;i<2;i++) { 
			if(id.charAt(i)>='A' && id.charAt(i)<='Z') {
				huruf++; 
			}
			else {
				break; 
			}
		}
		
		return huruf;
	}
	
	//Cek apakah karakter ke-2 (dalam array) merupakan '-'
	private static int cekTanda(String id) {
		int tanda=0;
		
		for (int i=0;i<1;i++) { 
			if(id.charAt(2)=='-') {
				tanda++; 
			}
			else {
				break; 
			}
		}
		
		return tanda;
	}
	
	//Cek apakah keempat karakter dibelakang merupakan angka
	private static int cekAngka(String id, int panjang) {
		int angka=0;
		
		for (int i=panjang-1;i>=3;i--) { 
			if(id.charAt(i)>='0' && id.charAt(i)<='9') {
				angka++; 
			}
			else {
				break; 
			}
		}
		
		return angka;
	}
	
	//Untuk update, user dapat menginput id yang baru, bukan hasil random
	private static String changeId() {
		int panjang=0, huruf=0, tanda=0, angka=0;
		String id="";
		
		do {
			System.out.print("Input kode karyawan [MM-XXXX]: ");
			id = scan.nextLine();
			panjang = id.length();
			huruf = cekHuruf(id);
			tanda = cekTanda(id);
			angka = cekAngka(id, panjang);
		} while(panjang!=7 || huruf!=2 || tanda!=1 || angka!=4);
		
		return id;
	}
		
	//Untuk update, user dapat menginput gaji yang baru, bukan disesuaikan dari jabatan
	private int changeGaji() {
		int gaji=0;
		
		do {
			System.out.print("Input gaji karyawan: ");
			gaji = scan.nextInt();
			scan.nextLine();
		} while(gaji>=1000000000);
		
		return gaji;
	}
	
	//Lihat tabel dulu, kemudian update
	private void update() {
		int pilih3=0;
		
		view();
		
		do {
			System.out.print("Input angka dari list data yang ingin di update [1.." + arr.size() + "]: ");
			pilih3 = scan.nextInt();
			scan.nextLine();
		} while(pilih3<1 || pilih3>arr.size());
		
		System.out.println("Input data BARU");
		
		String id=changeId();
		String nama=addNama();
		String jenis=addJenis();
		String jabatan=addJabatan();
		int gaji=changeGaji();
		
		System.out.printf("Berhasil menambahkan karyawan dengan id %s\n", id);
		
		Encap baru = new Encap(id, nama, jenis, jabatan, gaji, time);
		arr.set(pilih3-1, baru);
		
		addBonus(jabatan);
		
		enter();
	}
	
	//Lihat tabel dulu, kemudian delete
	private void delete() {
		int pilih2=0;
		
		view();
		
		do {
			System.out.print("Input angka dari list data yang ingin di delete [1.." + arr.size() + "]: ");
			pilih2 = scan.nextInt();
			scan.nextLine();
		} while(pilih2<1 || pilih2>arr.size());
		
		String id = arr.get(pilih2-1).getId();
		arr.remove(pilih2-1);
		
		System.out.printf("Berhasil menghapus karyawan dengan id %s\n", id);
		
		enter();
	}
	
}