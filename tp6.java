package tp6;
public  class document{
	private String titre;
    private int numero;
    private int nbpages;
    public document(string titre,int numero,int nbpages) {
    	this.titre=titre;
    	this.numero=numero;
    	this.nbpages=nbpages;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public int getnumero() {
        return numero;
    }
    public void setnumero(int numero) {
        this.numero = numero;
    }
    public int getnbpages() {
        return nbpages;
    }
    public void setnbpages(int nbpages) {
        this.nbpages =nbpages ;
    }
    
}
public void Edition() {
    System.out.println("Classe Document :");
    System.out.println("Titre : " + titre);
    System.out.println("Numero : " + numero);
    System.out.println("Nombre de pages : " + nbpages);
}
    
public class Article extends document {
	private String auteur;
    public Article(String titre, int numero, int nbPages,String auteur) {
        super(titre, numero, nbpages);
        this.auteur = auteur;
    }
        
    public String getauteur() {
    	return auteur;
            
        }

     public void setauteur(String auteur) {
         this.auteur = auteur;
        }
     public void Edition() {
    	    super.Edition();
    	    System.out.println("Classe Article :");
    	    System.out.println("Auteur : " + auteur);
    	}
}
public class Livre extends document{
	private String editeur;
    public Livre(String titre, int numero, int nbPages,String auteur, String editeur) {
        super(titre, numero, nbpages, auteur);
        this.editeur = editeur;
  }
        public String getediteur() {
            return editeur;
       }
        public void setediteur(String editeur) {
             this.editeur = editeur;
       } 
        public void Edition() {
            super.Edition();
            System.out.println("Classe Livre :");
            System.out.println("Editeur : " + editeur);
        }
        }
        }

public class Periodique extends document {
	private String frequence;
    public Periodique(String titre, int numero, int nbPages,String frequence) {
        super(titre, numero, nbpages);
        this.frequence = frequence;
    }
    public String getFrequence() {
        return frequence;
    }
    public void setFrequence(String frequence) {
        this.frequence = frequence;
    }
    public void Edition() {
        super.Edition();
        System.out.println("Classe Periodique :");
        System.out.println("Frequence : " + frequence);
    }
}

public class Bibliotheque {
    private document[] listdoc;
    private int nb;
    private int capacite;
    public Bibliotheque(int capacite) {
        this.capacite = capacite;
        this.listdoc= new document[capacite];
        this.nb=0;
    }
    public int getCapacite() {
        return capacite;
    }
    public int nb() {
        return nb;
}

public void Ajout_doc (document d) {
	 if (nb<capacite) {
         int i = nb- 1;	
         while (int i>= 0 && listdoc[i].getnumero() > d.getnumero()) {
             listdoc[i+1] = listdoc[i];
             i--;
}
         listdoc[i+1]= d;
         nb++;
      else {
    	  System.out.println("pleine");
      }
             
         }
public Supprim_doc (int num) {
	int i = 0;
    while (i < nb && listdoc[i].getnumero() != num) {
        i++;
    }
    if (i == nb) {
        System.out.println("introuvable ");
    } else {
        for (int j = i; j <nb- 1; j++) {
            listdoc[j] =listdoc[j+1];
        }
        nb--;
        listdoc[nb]=null;
    }
}
	

public void Inventaire_doc() {
    for (int i = 0; i < nb; i++) {
       listdoc[i].Edition();
    }
}


public Bibliotheque liste_livre() {
    Bibliotheque bib = new Bibliotheque(capacite);
    for (int i=0; i <nb; i++) {
        if (listdoc[i] instanceof Livre) {
            bib.Ajout_doc(listdoc[i]);
        }
    }

    return bib;
}

public Bibliotheque liste_article() {
    Bibliotheque bib = new Bibliotheque(capacite);
    for (int i=0; i<nb; i++) {
        if (listdoc[i] instanceof Article && !(listdoc[i] instanceof Livre)) {
            bib.Ajout_doc(listdoc[i]);
        }
    }

    return bib;
}
public Bibliotheque liste_docsimples() {
    Bibliotheque bib = new Bibliotheque(capacite);
    for (int i=0; i <nb; i++) {
        if (listdoc[i].getClass() == document.class) {
            bib.Ajout_doc(listdoc[i]);
        }
    }

    return bib;
}

public Bibliotheque liste_periodique() {
    Bibliotheque bib = new Bibliotheque(capacite);
    for (int i=0; i <nb; i++) {
        if (listdoc[i] instanceof Periodique) {
            bib.Ajout_doc(listdoc[i]);
        }
    }
    return bib;
}

}


public class Main {
    public static void main(String[] args) {
        Bibliotheque bib = new Bibliotheque(10);
        bib.Ajout_doc(new document("Doc", 13, 2));
        bib.Inventaire_doc();
        System.out.println("nombre de documents :"+ bib.getnb());
        System.out.println("Capacite : " + bib.getCapacite());
        bib.liste_livre().Inventaire_doc();
        bib.liste_article().Inventaire_doc();;
        bib.liste_docsimples().Inventaire_doc();
        bib.liste_periodique().Inventaire_doc();
        bib.Supprim_doc(1);
        bib.Inventaire_doc();
    
        
    }
}












         
         












        
        
        
        
   
        
        
        
        
            

    
    
    
    
    

    

    
	
}

