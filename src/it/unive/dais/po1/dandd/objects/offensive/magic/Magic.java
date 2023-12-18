package it.unive.dais.po1.dandd.objects.offensive.magic;

import it.unive.dais.po1.dandd.figures.Restore;
import it.unive.dais.po1.dandd.objects.defensive.DefensiveObject;
import it.unive.dais.po1.dandd.objects.offensive.OffensiveObject;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@XmlRootElement
@XmlType
public class Magic implements OffensiveObject, DefensiveObject {
    @XmlElement
    private int defense;
    @XmlAttribute
    private int damage;
    @XmlAttribute
    private int recovery;
    @XmlAttribute
    private int skip_next_rounds;

    public static void marshal(Magic magic)
            throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Magic.class);
        Marshaller mar= context.createMarshaller();
        mar.marshal(magic, new File("./magic.xml"));
    }
    public static Magic unmarshall()
            throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Magic.class);
        return (Magic) context.createUnmarshaller()
                .unmarshal(new FileReader("./magic.xml"));
    }


    /**
     * This exists only because of JAXB. Do not utilize it!
     */
    public Magic() {

    }

    public Magic(int defense, int damage, int recovery) {
        assert damage >= 0;
        if(damage>=0)
            this.damage = damage;
        else this.damage = 1;
        if(defense>=0)
            this.defense = defense;
        else this.defense = 0;
        if(recovery>=0)
            this.recovery = recovery;
        else recovery = 0;
        skip_next_rounds = 0;
    }

    public int getDefense() {
        if(this.skip_next_rounds>0)
            return 0;
        else
            return this.defense;
    }

    @Override
    public String toString() {
        return "Magic{" +
                "defense=" + defense +
                ", damage=" + damage +
                ", recovery=" + recovery +
                ", skip_next_rounds=" + skip_next_rounds +
                '}';
    }

    @Override
    public int getDamage() {
        int damage = this.getInnerDamage();
        if(this.skip_next_rounds>0) {
            //this.skip_next_rounds --;
            return 0;
        }
        this.skip_next_rounds = this.recovery;
        return damage;
    }

    @Restore(amount=1)
    private void restoreMagic() {
        if(this.skip_next_rounds>0)
            this.skip_next_rounds --;
    }

    @Override
    public int getInnerDamage() {
        return this.damage;
    }


    public int getInfoDefense() {
        return this.defense;
    }
    public int getStrength() { return this.getInnerDamage()+this.getInfoDefense();}
}
