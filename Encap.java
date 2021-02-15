public class Encap {
	
	String id, nama, jenis, jabatan;
	double gaji;
	int time;
	
	public Encap(String id, String nama, String jenis, String jabatan, double gaji, int time) {
		super();
		this.id = id;
		this.nama = nama;
		this.jenis = jenis;
		this.jabatan = jabatan;
		this.gaji = gaji;
		this.time = time;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getJenis() {
		return jenis;
	}
	public void setJenis(String jenis) {
		this.jenis = jenis;
	}
	public String getJabatan() {
		return jabatan;
	}
	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}
	public double getGaji() {
		return gaji;
	}
	public void setGaji(double gaji) {
		this.gaji = gaji;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
}