package Practice6.parser;

import Practice6.entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SaxParser {

    private File file;
    private List<String> beerList;
    private List<Beer> beers;
    private int countOfEntities = 0;

    public SaxParser(File file) {
        this.file = file;
        beerList = new ArrayList<>();
        beers=new ArrayList<>();
    }

    public void parseFile() {
        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean name = false;
                boolean type = false;
                boolean al = false;
                boolean manufacturer = false;
                boolean ingredients = false;
                boolean oborot = false;
                boolean transparency = false;
                boolean filter = false;
                boolean nutritionalValue = false;
                boolean sposobRazliva = false;
                boolean objem = false;
                boolean material = false;

                public void startElement(String uri, String localName, String qName,
                                         Attributes attributes) throws SAXException {

                    System.out.println("Start Element :" + qName);

                    if (qName.equalsIgnoreCase("Beer")){
                        String typeOfBeer=attributes.getValue("xsi:type");
                        beerList.add(typeOfBeer);
                    }

                    if (qName.equalsIgnoreCase("NAME")) {
                        name = true;
                    }

                    if (qName.equalsIgnoreCase("TYPE")) {
                        type = true;
                    }

                    if (qName.equalsIgnoreCase("AL")) {
                        al = true;
                    }

                    if (qName.equalsIgnoreCase("MANUFACTURER")) {
                        manufacturer = true;
                    }

                    if (qName.equalsIgnoreCase("INGREDIENTS")) {
                        ingredients = true;
                    }

                    if (qName.equalsIgnoreCase("OBOROT")) {
                        oborot = true;
                    }

                    if (qName.equalsIgnoreCase("PROZRACHNOST")) {
                        transparency = true;
                    }

                    if (qName.equalsIgnoreCase("FILTER")) {
                        filter = true;
                    }

                    if (qName.equalsIgnoreCase("PISHPRICE")) {
                        nutritionalValue = true;
                    }

                    if (qName.equalsIgnoreCase("SPOSOBRAZLIVA")) {
                        sposobRazliva = true;
                    }

                    if (qName.equalsIgnoreCase("OBJEM")) {
                        sposobRazliva = true;
                    }

                    if (qName.equalsIgnoreCase("MATERIAL")) {
                        sposobRazliva = true;
                    }

                }

                public void endElement(String uri, String localName,
                                       String qName) throws SAXException {

                    System.out.println("End Element :" + qName);

                }

                public void characters(char ch[], int start, int length) throws SAXException {

                    if (name) {
                        beerList.add(new String(ch, start, length));
                        System.out.println("Name : " + new String(ch, start, length));
                        name = false;
                    }

                    if (type) {
                        beerList.add(new String(ch, start, length));
                        System.out.println("Type : " + new String(ch, start, length));
                        type = false;
                    }

                    if (al) {
                        beerList.add(new String(ch, start, length));
                        System.out.println("Al : " + new String(ch, start, length));
                        al = false;
                    }

                    if (manufacturer) {
                        beerList.add(new String(ch, start, length));
                        System.out.println("Manufacturer : " + new String(ch, start, length));
                        manufacturer = false;
                    }

                    if (ingredients) {
                        System.out.println("Ingredients : " + new String(ch, start, length));
                        ingredients = false;
                    }

                    if (oborot) {
                        beerList.add(new String(ch, start, length));
                        System.out.println("Oborot : " + new String(ch, start, length));
                        oborot = false;
                    }

                    if (transparency) {
                        beerList.add(new String(ch, start, length));
                        System.out.println("Prozrachnost : " + new String(ch, start, length));
                        transparency = false;
                    }

                    if (filter) {
                        beerList.add(new String(ch, start, length));
                        System.out.println("Filter : " + new String(ch, start, length));
                        filter = false;
                    }

                    if (nutritionalValue) {
                        beerList.add(new String(ch, start, length));
                        System.out.println("PishPrice : " + new String(ch, start, length));
                        nutritionalValue = false;
                    }

                    if (sposobRazliva) {
                        if (!new String(ch, start, length).contains(System.lineSeparator())) {
                            beerList.add(new String(ch, start, length));
                            System.out.println("Spill : " + new String(ch, start, length));
                            sposobRazliva = false;
                        }
                    }
                }

            };

            saxParser.parse(file, handler);
            mapData();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void mapData(){

        for (int count=0;count<beerList.size();count++){

            switch (beerList.get(count)){
                case "AlcBeer":
                    AlcBeer alcBeer=new AlcBeer();
                    alcBeer.setName(beerList.get(count+=1));
                    alcBeer.setType(beerList.get(count+=1));
                    alcBeer.setAl(Boolean.valueOf(beerList.get(count+=1)));
                    alcBeer.setManufacturer(beerList.get(count+=1));
                    alcBeer.setIngredients(new Ingredient[]{new Ingredient(beerList.get(count+=1)),
                            new Ingredient(beerList.get(count+=1)),new Ingredient(beerList.get(count+=1))});
                    alcBeer.setTurnover(beerList.get(count+=1));
                    alcBeer.setTransparency(beerList.get(count+=1));
                    alcBeer.setFilter(Boolean.valueOf(beerList.get(count+=1)));
                    alcBeer.setNutritionalValue(beerList.get(count+=1));
                    alcBeer.setSpill(new Spill(beerList.get(count+=1),beerList.get(count+=1)));
                    beers.add(alcBeer);

                    break;
                case "NonAlcBeer":
                    NonAlcBeer nonAlcBeer=new NonAlcBeer();
                    nonAlcBeer.setName(beerList.get(count+=1));
                    nonAlcBeer.setType(beerList.get(count+=1));
                    nonAlcBeer.setAl(Boolean.valueOf(beerList.get(count+=1)));
                    nonAlcBeer.setManufacturer(beerList.get(count+=1));
                    nonAlcBeer.setIngredients(new Ingredient[]{new Ingredient(beerList.get(count+=1)),
                            new Ingredient(beerList.get(count+=1)),new Ingredient(beerList.get(count+=1))});
                    nonAlcBeer.setTransparency(beerList.get(count+=1));
                    nonAlcBeer.setFilter(Boolean.valueOf(beerList.get(count+=1)));
                    nonAlcBeer.setNutritionalValue(beerList.get(count+=1));
                    nonAlcBeer.setSpill(new Spill(beerList.get(count+=1),beerList.get(count+=1)));
                    beers.add(nonAlcBeer);

                    break;
            }

        }
    }



}
