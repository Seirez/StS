import java.util.Scanner;

/*
Slay the Spire
Use case user
Menu
-Play
    -Standard
        -Pilih character
            -Pilih ascension (difficulty)
                -Map (encounters)
                    -Map randomization
                        -Random event
                        -Enemy encounter
                            -Normal
                            -Boss
                            -Elite
                        -Peaceful encounter
                            -Trader
                            -Chest
                            -Campfire

                    -Pilih encounter

                    -Battle
                        -Pilih card (action)
                            -Normal card
                            -Colorless card
                            -Status card
                            -Curse card
                        -Energy consumption
                        -End turn
                            -Energy reset
                            -Block reset (to 0)
                            -Enemy action
                        -Battle end (Reward)

                    -Standard campaign end (Unlocking new relics and more)
    -Daily climb
    -Custom

-Compedium
-Statistics
-Settings
-Patch notes
-Exit

Use case manajemen perusahaan
-Change daily climb level
-Database management
    -C (create/input)
    -R (read/retrieve)
    -U (update)
    -D (delete)

Use case direksi perusahaan
-view player statistic (which character that is being used the most and more)

*/

/*
// Class encounter
class Encounter{
	1. Random encounter
		a. Random event
	2. Enemy encounter
		a. Normal
		b. Boss
		c. Elite
	3. Peaceful encounter
		a. Trader
		b. Chest
		c. Campfire
	4. Events
}
*/

// Class hand untuk kartu yang dapat digunakan
// class Hand{

// }

// Main class (Runner)
class main {
    public static void main(String[] args) {
        // Starts the UI
        new MenuUI();

        // // inisialisasi
        // // Scanner
        // Scanner inmain = new Scanner(System.in);
        
        // // Characters
        // Character Ironclad = new Character(null, 0, 0);
        // Ironclad.setCharName("Ironclad");
        // Ironclad.setHealth(80);
        
        // Character Silent = new Character(null, 0, 0);
        // Silent.setCharName("Silent");
        // Silent.setHealth(70);

        // // Enemies
        // Enemy Enemy1 = new Enemy(null, 0, 0);
        // Enemy1.setCharName("Enemy1");
        // Enemy1.setHealth(30);
        
        // // Relics
        // Relic R1 = new Relic();
        // R1.setRName("Burning Blood");

        // Relic R2 = new Relic();
        // R2.setRName("Ring of The Snake");
        
        // // Buffs
        // Buff B1 = new Buff();
        // B1.name = "Strength";
        
        // Buff B2 = new Buff();
        // B2.name = "Dexterity";
        
        // Buff B3 = new Buff();
        // B3.name = "Regen";
        
        // // Debuffs
        // Debuff DB1 = new Debuff();
        // DB1.name = "Vulnerable";
        
        // Debuff DB2 = new Debuff();
        // DB2.name = "Frail";
        
        // Debuff DB3 = new Debuff();
        // DB3.name = "Weak";

        // // Card
        // Ncard Card1 = new Ncard(null, 0, 0, 0, 0);
        // Card1.setCardName("Attack");
        // Card1.setDamage(8);
        // Card1.setCardCost(1);

        // Ncard Card2 = new Ncard(null, 0, 0, 0, 0);
        // Card2.setCardName("Heal & Defend");
        // Card2.setHeal(10);
        // Card2.setBlock(10);
        // Card2.setCardCost(2);

        // Ncard enemyaction = new Ncard(null, 0, 0, 0, 0);
        // enemyaction.setCardName("Enemy Action");
        // enemyaction.setDamage(10);

        // // Energy
        // Energy turn = new Energy();
        // turn.setEnergy(3);
        // turn.setMaxEnergy(3);
        
        // // Membuka main menu
        // Menu Run = new Menu();

        // // Loop menu
        // for(int a=0;a<1;){
        //     // Masuk main menu (pemilihan character)
        //     int check = Run.MainMenu(Ironclad,Silent);

        //     // Cek pilihan
        //     if (check==1){
        //         // Memilih character Ironclad
        //         Run.Battle(Ironclad,turn,Enemy1,Card1,Card2,enemyaction);
        //     }
        //     else if (check==2){
        //         // Memilih character Silent
        //         Run.Battle(Silent,turn,Enemy1,Card1,Card2,enemyaction);
        //     }
        //     else{
        //         // Tidak memilih character (Exit)
        //         System.out.print("\n");
        //         System.out.println("Program ends");
        //     }

        //     Run.clearscreen();

        //     // Setelah preview battle
        //     // Meminta keputusan dengan scanner
        //     System.out.println("Try again?(y/n)");
        //     String again = inmain.nextLine();

        //     // Program tidak berhenti bila meng-input 'y'
        //     if (again=="y"||again=="Y"){}

        //     // Program berhenti bila tidak meng-input 'y'
        //     else{
        //         a++;
        //         System.out.println("Program ends");;
        //     }
        // }

        // inmain.close();
    }
}