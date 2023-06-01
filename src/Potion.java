// Class potion
class Potion{
    // inisialisasi
	private String PName;
  	private int Slot=3;

    // Mengganti/memberi nama potion
    void setPName(String name){
        this.PName = name;
    }
    // Mengambil nama potion
    String getPName(){
        return this.PName;
    }

    // Mengganti/memberi jumlah slot
    void setSlot(int Slot){
        this.Slot = Slot;
    }
    // Mengambil jumlah slot
    int getSlot(){
        return this.Slot;
    }
}