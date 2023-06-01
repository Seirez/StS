// Class energy
class Energy{
    // inisialisasi
    private int Energy;
    private int MaxEnergy;

    // Mengganti/memberi jumlah Energy
    void setEnergy(int Energy){
        this.Energy = Energy;
    }
    // Mengambil jumlah Energy
    int getEnergy(){
        return this.Energy;
    }

    // Mengganti/memberi Max Energy
    void setMaxEnergy(int MaxEnergy){
        this.MaxEnergy = MaxEnergy;
    }
    // Mengambil Max Energy
    int getMaxEnergy(){
        return this.MaxEnergy;
    }
    
    // Method energy bertambah
    int increase(int Energy,int Cost){
        Energy=Energy+Cost;
        return Energy;
    }
    // Method energy berkurang
    int reduce(int Energy,int Cost){
        Energy=Energy-Cost;
        return Energy;
    }
    // Method energy reset
    int reset(int Max){
        Energy=Max;
        return Energy;
    }
}