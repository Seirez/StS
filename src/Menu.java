import java.util.Scanner;

// Class Menu
class Menu{
    // inisialisasi
    // Scanner
    Scanner in = new Scanner(System.in);

    //Menampilkan Main Menu
    int MainMenu(Character Ironclad, Character Silent){
        // Menu dalam loop
        for(int i = 0; i<1;){
            clearscreen();

            // Menunjukkan pilihan
            System.out.println("Main Menu");
            System.out.println("-----------------------------");
            System.out.println("1. Pilih Character");
            System.out.println("2. -");
            System.out.println("3. Exit");
            System.out.println("-----------------------------");

            // Pilihan diminta dan diterima dengan inputan scanner
            System.out.println("Pilih:");
            int key1 = in.nextInt();
            System.out.print("\n");

            // Pilihan dengan menggunakan switch
            switch (key1) {
                case 1:
                clearscreen();

                // Menunjukkan pilihan
                System.out.println("Pilih Character");
                System.out.println("-----------------------------");
                System.out.println("1. "+Ironclad.getCharName());
                System.out.println("2. "+Silent.getCharName());
                System.out.println("-----------------------------");

                // Pilihan diminta dan diterima dengan inputan scanner
                System.out.println("Pilih:");
                int key2 = in.nextInt();

                // Pilihan dengan menggunakan switch
                switch (key2) {
                    case 1:
                        clearscreen();

                        System.out.println("Enemy Encounter");
                        i++;
                        return 1;

                    case 2:
                        clearscreen();

                        System.out.println("Enemy Encounter");
                        i++;
                        return 2;
                        
                    default:
                        System.out.println("Unknown Command");
                        break;
                    }
                    return 0;

                case 2:
                    System.out.println();
                    return 0;

                case 3:
                    i++;
                    return 0;

                default:
                    System.out.println("Unknown Command");
                    break;
            }
        }
        return 0;
    }

    //Menampilkan menu battle
    void Battle(Character player, Energy turn, Enemy enemy, Ncard card1, Ncard card2, Ncard ecard){
        // Menu dalam loop
        for(int y = 0; y<1;){

            // Cek hp player dan enemy
            if(player.getHealth()<=0 || enemy.getHealth()<=0){
                y++;
                System.out.println("Congratulations you've reached the end of the current development!");
                System.out.println("In other words you've either killed the enemy or managed to get yourself killed!");
                System.out.print("\n");
            }

            else{
                // Menunjukkan deskripsi player dan enemy
                System.out.println("-----------------------------");
                player.showDesc();
                System.out.print("\n");
                enemy.showDesc();
                System.out.println("-----------------------------");
                System.out.print("\n");
                
                // Menunjukkan pilihan
                System.out.println("Energy : "+turn.getEnergy());
                System.out.println("-----------------------------");
                System.out.println("1. Pilih Card");
                System.out.println("2. End Turn");
                System.out.println("3. Exit Game");
                System.out.println("-----------------------------");

                // Pilihan diminta dan diterima dengan inputan scanner
                System.out.println("Pilih:");
                int key3 = in.nextInt();

                // Pilihan dengan menggunakan switch
                switch (key3) {
                    case 1:
                        clearscreen();

                        // Menunjukkan pilihan
                        System.out.println("Pilih Card");
                        System.out.println("-----------------------------");

                        // Menunjukkan deskripsi card
                        System.out.print("1. ");
                        card1.show();
                        System.out.print("2. ");
                        card2.show();

                        System.out.println("3. Cancel");
                        System.out.println("-----------------------------");

                        // Pilihan diminta dan diterima dengan inputan scanner
                        System.out.println("Pilih:");
                        int key4 = in.nextInt();
                        System.out.print("\n");

                        // Pilihan dengan menggunakan switch
                        switch (key4) {
                            case 1:
                                // Cek apa jumlah energy yang dimiliki cukup
                                if (checkNeeds(turn.getEnergy(),card1.getCardCost())){
                                    clearscreen();

                                    // Pemberitahuan efek card (damage)
                                    card1.showHistory(player.getCharName(),card1.getDamage());
                                    
                                    // Kalkulasi efek card
                                    enemy.setHealth(enemy.damage(enemy.getHealth(),card1.getDamage(),enemy.getCblock()));
                                    turn.setEnergy(turn.reduce(turn.getEnergy(),card1.getCardCost()));

                                    // Pemberitahuan sisa energy setelah digunakan
                                    card1.showHistory(turn.getEnergy());
                                }

                                // Pemberitahuan energy tidak cukup
                                else{
                                    System.out.println("Not enough energy");
                                }
                                break;
                            case 2:
                                // Cek apa jumlah energy yang dimiliki cukup
                                if (checkNeeds(turn.getEnergy(),card2.getCardCost())){
                                    clearscreen();

                                    // Pemberitahuan efek card (heal & block)
                                    card2.showHistory(player.getCharName(),player.getHealth(),card2.getHeal());
                                    card2.showHistory(player.getCblock(),card2.getBlock());

                                    // Kalkulasi efek card
                                    player.setHealth(player.heal(player.getHealth(),card2.getHeal()));
                                    player.setCblock(player.getCblock()+card2.getBlock());
                                    turn.setEnergy(turn.reduce(turn.getEnergy(),card2.getCardCost()));

                                    // Pemberitahuan sisa energy setelah digunakan
                                    card1.showHistory(turn.getEnergy());
                                }

                                // Pemberitahuan energy tidak cukup
                                else{
                                    clearscreen();
                                    System.out.println("Not enough energy");
                                }
                                break;
                            default:
                                System.out.println("Unknown Command");
                                break;
                        }
                        break;
                    case 2:
                        // Turn di-akhiri (energy di-reset menjadi penuh)
                        turn.reset(turn.getMaxEnergy());

                        clearscreen();

                        System.out.println("You ended your turn");
                        // Enemy mendapat giliran (menyerang balik)
                        player.setHealth(player.damage(player.getHealth(),ecard.getDamage(),player.getCblock()));
                        ecard.showHistory(enemy.getCharName(),ecard.getDamage());
                        break;
                    
                    case 3:
                        y++;
                        break;
                
                    default:
                        System.out.println("Unknown Command");
                        break;
                }
            }
        }
    }

    // Method cek kecukupan energy
    boolean checkNeeds(int energy,int cost){
        boolean result = (energy >= cost);
	    return (result);
	}

    public void clearscreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}