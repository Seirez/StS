// Abstract untuk status effect (buff/debuff)
abstract class Status {
    // inisialisasi
    private String Name;
    private int Duration;

    // Mengganti/memberi nama
    void setName(String Name){
        this.Name = Name;
    }
    // Mengambil nama
    String getName(){
        return this.Name;
    }

    // Mengganti/memberi durasi
    void setDuration(int Duration){
        this.Duration = Duration;
    }
    // Mengambil durasi
    int getDuration(){
        return this.Duration;
    }
}