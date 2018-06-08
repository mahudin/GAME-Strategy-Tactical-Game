package dev.army;

import dev.interfejsy.strzelanie.NieStrzelam;
import dev.interfejsy.strzelanie.Strzelam;
import dev.interfejsy.walka.NieWalcz;
import dev.interfejsy.walka.Walcz;

public class £ucznik extends Army {
	public void init_features(){
		strzelanie_interfejs=new Strzelam();
		walka_interfejs=new NieWalcz();
	}
	public £ucznik(){
		init_features();
	}
	public £ucznik(Jednostka jednostka){
		super(jednostka);
		init_features();
	}
	public String _toString(){
        return "³ucznik";
    }
}
