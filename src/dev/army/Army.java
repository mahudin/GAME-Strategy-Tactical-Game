package dev.army;

import dev.interfejsy.strzelanie.StrzelanieInterfejs;
import dev.interfejsy.walka.WalkaInterfejs;

public abstract class Army implements Jednostka {
	StrzelanieInterfejs strzelanie_interfejs;
	WalkaInterfejs walka_interfejs;
	
	protected Jednostka jednostka;
	protected Army(Jednostka jednostka){
		this.jednostka=jednostka;
	}
	protected Army(){}
	public abstract void init_features();
}
