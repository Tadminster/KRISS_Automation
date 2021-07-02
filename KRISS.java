import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class KRISS {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // physical, periodic set
    Hashtable<String, String> physicalTable = new Hashtable<>();
    Hashtable<String, String> result = new Hashtable<>();
    ArrayList<String> periodicTable = new ArrayList<>();
    physicalTable = labelingSet();
    periodicTable = periodicTableSet();

    // input and split
    String[] strs = sc.nextLine().split(" ");
    sc.close();

    // X - X - HERE - X
    result = informative(strs, physicalTable);

    // X - HERE - X - X
    result = findMaterial(strs, periodicTable, result);

    System.out.println("-----------------------------");
    System.out.println(result);

  }

  private static Hashtable<String, String> findMaterial(String[] strs, ArrayList<String> periodicTable,
      Hashtable<String, String> result) {
    int count = 1;
    for (int i = 0; i < strs.length; i++) {
      // exception
      Pattern pattern = Pattern.compile("(The)");
      Matcher matcher = pattern.matcher(strs[i]);
      if (matcher.find()) {
        continue;
      }

      // Find Material
      for (int j = 0; j < periodicTable.size(); j++) {
        pattern = Pattern.compile(periodicTable.get(j));
        matcher = pattern.matcher(strs[i]);
        if (matcher.find()) {
          result.put(strs[i], "m" + count + "-" + result.get(strs[i]));
          count++;
          break;
        }
      }
    }

    for (int i = 0; i < strs.length; i++) {
      Pattern pattern = Pattern.compile("(mp|ds|da|pp|pc|pv|pr|po|ps|pe|pre|pab|plec|mc|e|s)");
      Matcher matcher = pattern.matcher(result.get(strs[i]));
      if (matcher.find()) {
        result.put(strs[i], "o-" + result.get(strs[i]));
      }
    }
    return result;
  }

  private static Hashtable<String, String> informative(String[] strs, Hashtable<String, String> physicalTable) {
    Hashtable<String, String> result = new Hashtable<>();

    for (int i = 0; i < strs.length; i++) {
      if (physicalTable.containsKey(strs[i])) {
        result.put(strs[i], physicalTable.get(strs[i]));
      } else {
        result.put(strs[i], "o");
      }
    }

    return result;
  }

  private static ArrayList<String> periodicTableSet() {
    ArrayList<String> periodicTable = new ArrayList<>();

    // periodicTable.add("H");
    periodicTable.add("He");
    periodicTable.add("Li");
    periodicTable.add("Be");
    // periodicTable.add("B");
    // periodicTable.add("C");
    // periodicTable.add("N");
    // periodicTable.add("O");
    // periodicTable.add("F");
    periodicTable.add("Ne");
    periodicTable.add("Na");
    periodicTable.add("Mg");
    periodicTable.add("AI");
    periodicTable.add("Si");
    // periodicTable.add("P");
    // periodicTable.add("S");
    periodicTable.add("CI");
    periodicTable.add("Ar");
    // periodicTable.add("K");
    periodicTable.add("Ca");
    periodicTable.add("Sc");
    periodicTable.add("Ti");
    // periodicTable.add("V");
    periodicTable.add("Cr");
    periodicTable.add("Mn");
    periodicTable.add("Fe");
    periodicTable.add("Co");
    periodicTable.add("Ni");
    periodicTable.add("Cu");
    periodicTable.add("Zn");
    periodicTable.add("Ga");
    periodicTable.add("Ge");
    periodicTable.add("As");
    periodicTable.add("Se");
    periodicTable.add("Br");
    periodicTable.add("Kr");
    periodicTable.add("Rb");
    periodicTable.add("Sr");
    // periodicTable.add("Y");
    periodicTable.add("Zr");
    periodicTable.add("Nb");
    periodicTable.add("Mo");
    periodicTable.add("Tc");
    periodicTable.add("Ru");
    periodicTable.add("Rh");
    periodicTable.add("Pd");
    periodicTable.add("Ag");
    periodicTable.add("Cd");
    periodicTable.add("In");
    periodicTable.add("Sn");
    periodicTable.add("Sb");
    periodicTable.add("Te");
    // periodicTable.add("I");
    periodicTable.add("Xe");
    periodicTable.add("Cs");
    periodicTable.add("Ba");

    // 57-71
    periodicTable.add("La");
    periodicTable.add("Ce");
    periodicTable.add("Pr");
    periodicTable.add("Nd");
    periodicTable.add("Pm");
    periodicTable.add("Sm");
    periodicTable.add("Eu");
    periodicTable.add("Gd");
    periodicTable.add("Tb");
    periodicTable.add("Dy");
    periodicTable.add("Ho");
    periodicTable.add("Er");
    periodicTable.add("Tm");
    periodicTable.add("Yb");
    periodicTable.add("Lu");
    periodicTable.add("Lu");

    periodicTable.add("Hf");
    periodicTable.add("Ta");
    // periodicTable.add("W");
    periodicTable.add("Re");
    periodicTable.add("Os");
    periodicTable.add("Ir");
    periodicTable.add("Pt");
    periodicTable.add("Au");
    periodicTable.add("Hg");
    periodicTable.add("Tl");
    periodicTable.add("Pb");
    periodicTable.add("Bi");
    periodicTable.add("Po");
    periodicTable.add("At");
    periodicTable.add("Rn");
    periodicTable.add("Fr");
    periodicTable.add("Ra");

    // 89-103
    periodicTable.add("Ac");
    periodicTable.add("Th");
    periodicTable.add("Pa");
    // periodicTable.add("U");
    periodicTable.add("Np");
    periodicTable.add("Pu");
    periodicTable.add("Am");
    periodicTable.add("Cm");
    periodicTable.add("Bk");
    periodicTable.add("Cf");
    periodicTable.add("Es");
    periodicTable.add("Fm");
    periodicTable.add("Md");
    periodicTable.add("No");
    periodicTable.add("Lr");

    // 104-118
    periodicTable.add("Rf");
    periodicTable.add("Db");
    periodicTable.add("Sg");
    periodicTable.add("Bh");
    periodicTable.add("Hs");
    periodicTable.add("Mt");
    periodicTable.add("Ds");
    periodicTable.add("Rg");
    periodicTable.add("Cn");
    periodicTable.add("Nh");
    periodicTable.add("Fl");
    periodicTable.add("Mc");
    periodicTable.add("Lv");
    periodicTable.add("Ts");
    periodicTable.add("Og");

    return periodicTable;
  }

  private static Hashtable<String, String> labelingSet() {
    Hashtable<String, String> physicalProperties = new Hashtable<>();

    // material(m)
    // mp
    physicalProperties.put("properties", "mp");
    physicalProperties.put("conduction", "mp");
    physicalProperties.put("electronic", "mp");
    physicalProperties.put("thermochemical", "mp");
    physicalProperties.put("electrochemical,", "mp"); //////////////////
    physicalProperties.put("electrochemical", "mp");
    physicalProperties.put("charge", "mp");
    physicalProperties.put("electrically", "mp");
    physicalProperties.put("driving", "mp");
    physicalProperties.put("doping", "mp");
    physicalProperties.put("doped", "mp");
    physicalProperties.put("intrinsic", "mp");
    physicalProperties.put("electrons", "mp");
    physicalProperties.put("trapping/detrapping", "mp");
    physicalProperties.put("frequencies", "mp");
    physicalProperties.put("force", "mp");
    physicalProperties.put("endothermic", "mp");
    physicalProperties.put("transmittance", "mp");
    physicalProperties.put("bands", "mp");
    physicalProperties.put("stretching", "mp");
    physicalProperties.put("absorbance", "mp");
    physicalProperties.put("vibrational", "mp");
    physicalProperties.put("energy", "mp");
    physicalProperties.put("chemical", "mp");
    physicalProperties.put("atomic", "mp");
    physicalProperties.put("electromagnetic", "mp");
    physicalProperties.put("space‐charge‐limited", "mp");
    physicalProperties.put("opacity", "mp");
    physicalProperties.put("electric", "mp");
    physicalProperties.put("field", "mp");
    physicalProperties.put("transport", "mp");
    physicalProperties.put("metal", "mp");
    physicalProperties.put("scattering", "mp");
    physicalProperties.put("mass", "mp");
    physicalProperties.put("excited", "mp");
    physicalProperties.put("semiconductor", "mp");
    physicalProperties.put("insulator", "mp");
    physicalProperties.put("carbon-rich", "mp");
    physicalProperties.put("phase", "mp");
    physicalProperties.put("holes", "mp");
    physicalProperties.put("barrier", "mp");
    physicalProperties.put("(HOMO)", "mp");
    physicalProperties.put("(LUMO)", "mp");
    physicalProperties.put("chemically", "mp");
    physicalProperties.put("valence", "mp");
    physicalProperties.put("solid-state", "mp");
    physicalProperties.put("physical", "mp");
    physicalProperties.put("metallic", "mp");
    physicalProperties.put("magneto-electrical", "mp");
    physicalProperties.put("ferromagnetism", "mp");
    physicalProperties.put("insulating", "mp");
    physicalProperties.put("magnetic", "mp");
    physicalProperties.put("diamagnetic", "mp");

    // device(d)
    // ds
    physicalProperties.put("structure", "ds");
    physicalProperties.put("electrode,TE,BE", "ds");
    physicalProperties.put("conventional", "ds");
    physicalProperties.put("electrolyte, dielectric", "ds");
    physicalProperties.put("buffer", "ds");
    physicalProperties.put("active", "ds");
    physicalProperties.put("top,bottom", "ds");
    physicalProperties.put("layer", "ds");
    physicalProperties.put("substrate", "ds");
    physicalProperties.put("thickness,thick,tox", "ds");
    physicalProperties.put("multistack,vertical", "ds");
    physicalProperties.put("channel, Cluster", "ds");
    physicalProperties.put("channel", "ds");
    physicalProperties.put("Cluster", "ds");
    physicalProperties.put("MIM", "ds");
    physicalProperties.put("cross-point", "ds");
    physicalProperties.put("nanowire, nanodot, nanomesh", "ds"); //////////////
    physicalProperties.put("nanowire", "ds");
    physicalProperties.put("nanodot", "ds");
    physicalProperties.put("nanomesh", "ds");
    physicalProperties.put("X-point", "ds");
    physicalProperties.put("oxram", "ds");
    physicalProperties.put("CBRAM", "ds");
    physicalProperties.put("terminal", "ds");
    physicalProperties.put("surface", "ds");
    physicalProperties.put("PMC", "ds");
    physicalProperties.put("ReRAM", "ds");
    physicalProperties.put("width", "ds");
    physicalProperties.put("pitch", "ds");
    physicalProperties.put("film", "ds");
    physicalProperties.put("films", "ds");
    physicalProperties.put("multilayer", "ds");

    // da
    physicalProperties.put("application", "da");
    physicalProperties.put("selector", "da");
    physicalProperties.put("memristors, memristive", "da");
    physicalProperties.put("Memory", "da");
    physicalProperties.put("neuromorphic", "da");
    physicalProperties.put("switch", "da");
    physicalProperties.put("mulit-level,MLC", "da");
    physicalProperties.put("memories", "da");
    physicalProperties.put("Neural", "da");
    physicalProperties.put("NVM", "da");
    physicalProperties.put("storage", "da");
    physicalProperties.put("floating‐gate", "da");
    physicalProperties.put("nonvolatile", "da");
    physicalProperties.put("transistors", "da");

    // performance(p)
    // pp
    physicalProperties.put("Power", "pp");
    physicalProperties.put("consumption", "pp");

    // pc
    physicalProperties.put("current", "pc");
    physicalProperties.put("Ion,", "pc"); //////////////////
    physicalProperties.put("Ion", "pc");
    physicalProperties.put("Iset", "pc");
    physicalProperties.put("Ioff,", "pc"); //////////////////
    physicalProperties.put("Ioff,", "pc");
    physicalProperties.put("leakage", "pc");
    physicalProperties.put("Ileak", "pc");
    physicalProperties.put("Ireset", "pc");
    physicalProperties.put("compliance", "pc");
    physicalProperties.put("Iprog", "pc");
    physicalProperties.put("Ierase", "pc");
    physicalProperties.put("Icc", "pc");
    physicalProperties.put("IHRS", "pc");
    physicalProperties.put("ILRS", "pc");

    // pv
    physicalProperties.put("voltage", "pv");
    physicalProperties.put("Vset", "pv");
    physicalProperties.put("Vreset", "pv");
    physicalProperties.put("Vforming", "pv");
    physicalProperties.put("Vread", "pv");
    physicalProperties.put("Verase", "pv");
    physicalProperties.put("Vprogram", "pv");

    // pr
    physicalProperties.put("resistance", "pr");
    physicalProperties.put("resistive", "pr");
    physicalProperties.put("HRS,LRS", "pr");
    physicalProperties.put("conductivity", "pr");
    physicalProperties.put("RH,RL, Roff, Ron", "pr"); ////////////////// 이거 물어보3//////////////////
    physicalProperties.put("high‐resistance,low-resistance", "pr");
    physicalProperties.put("resistance-state", "pr");

    // po
    physicalProperties.put("operating", "po");
    physicalProperties.put("Forming-free,semi-forming", "po");
    physicalProperties.put("unipolar,bipolar,complementary", "po");
    physicalProperties.put("ON, OFF", "po"); ////////////////// 이거 물어보3//////////////////
    physicalProperties.put("ON", "po");
    physicalProperties.put("OFF", "po");
    physicalProperties.put("operation", "po");
    physicalProperties.put("Program,erase", "po");
    physicalProperties.put("read, write", "po"); //////////////////
    physicalProperties.put("read", "po");
    physicalProperties.put("write", "po");
    physicalProperties.put("rupture", "po");
    physicalProperties.put("fast,slow", "po");
    physicalProperties.put("fast", "po");
    physicalProperties.put("slow", "po");
    physicalProperties.put("forming,formation,Electroforming", "po");
    physicalProperties.put("switching", "po");
    physicalProperties.put("breakdown", "po");
    physicalProperties.put("high,low", "po");
    physicalProperties.put("high", "po");
    physicalProperties.put("low", "po");
    physicalProperties.put("set,reset", "po");
    physicalProperties.put("set", "po");
    physicalProperties.put("reset", "po");
    physicalProperties.put("positive,negative", "po");
    physicalProperties.put("positive", "po");
    physicalProperties.put("negative", "po");
    physicalProperties.put("threshold", "po");
    physicalProperties.put("sweep", "po");
    physicalProperties.put("dissolution", "po");
    physicalProperties.put("current–voltage", "po");
    physicalProperties.put("I-V", "po");
    physicalProperties.put("polarity", "po");

    // ps
    physicalProperties.put("speed", "ps");

    // pe
    physicalProperties.put("endurance", "pe");
    physicalProperties.put("cycles", "pe");
    physicalProperties.put("cycling", "pe");
    physicalProperties.put("cyclability", "pe");

    // pre
    physicalProperties.put("retention", "pre");
    physicalProperties.put("duration", "pre");
    physicalProperties.put("lifetime", "pre");

    // pab
    physicalProperties.put("reliability", "pab");
    physicalProperties.put("stability", "pab");
    physicalProperties.put("variability", "pab");
    physicalProperties.put("disturbance", "pab");
    physicalProperties.put("uniformity", "pab");
    physicalProperties.put("dispersion", "pab");
    physicalProperties.put("distributions ,distributions", "pab"); //////////////////
    physicalProperties.put("distributions", "pab"); //////////////////
    physicalProperties.put("cumulative", "pab");
    physicalProperties.put("Fluctuation", "pab");
    physicalProperties.put("deviation", "pab");
    physicalProperties.put("window", "pab");
    physicalProperties.put("non-uniformity", "pab");
    physicalProperties.put("uniform", "pab");
    physicalProperties.put("reproducible", "pab");
    physicalProperties.put("probabilities", "pab");

    // plec
    physicalProperties.put("selectivity", "plec");
    physicalProperties.put("ratio", "plec");
    physicalProperties.put("Non-linearity", "plec");

    // mechanism(mc)
    // mc
    physicalProperties.put("VCM", "mc");
    physicalProperties.put("URS,BRS,CRS", "mc");
    physicalProperties.put("Schottky", "mc");
    physicalProperties.put("oxidized", "mc");
    physicalProperties.put("ECM", "mc");
    physicalProperties.put("frenkel", "mc");
    physicalProperties.put("ohmic", "mc");
    physicalProperties.put("interface-switching", "mc");
    physicalProperties.put("electrochemical", "mc");
    physicalProperties.put("Poole", "mc");
    physicalProperties.put("reduction", "mc");
    physicalProperties.put("filament", "mc");
    physicalProperties.put("path", "mc");
    physicalProperties.put("precipitation", "mc");
    physicalProperties.put("thermal-chemical mechanism", "mc"); ////////////////// 이거 물어보3//////////////////
    physicalProperties.put("TCM", "mc");
    physicalProperties.put("SCLC, space-charge-limited-current", "mc");////////////////// 이거 물어보3//////////////////
    physicalProperties.put("transition", "mc");

    // environment (e)
    // e
    physicalProperties.put("humidity", "e");
    physicalProperties.put("time", "e");
    physicalProperties.put("dry", "e");
    physicalProperties.put("temperature", "e");
    physicalProperties.put("heat", "e");
    physicalProperties.put("vacuum", "e");
    physicalProperties.put("pressure", "e");
    physicalProperties.put("air", "e");

    // synthesis(s)
    // s
    physicalProperties.put("RF-sputtering", "s");
    physicalProperties.put("ALD (=Atomic Layer Deposition)", "s");
    physicalProperties.put("vapor", "s");
    physicalProperties.put("sputtering", "s");
    physicalProperties.put("CVD (=Chemical Vapor Deposition)", "s");
    physicalProperties.put("e-beam", "s");
    physicalProperties.put("PVD (=Physical Vapor Deposition)", "s");
    physicalProperties.put("evaporator", "s");
    physicalProperties.put("evaporation", "s");
    physicalProperties.put("PLD (=Pulsed Laser Deposition)", "s");
    physicalProperties.put("spin-coated", "s");
    physicalProperties.put("plasma", "s");
    physicalProperties.put("printing", "s");
    physicalProperties.put("annealing", "s");
    physicalProperties.put("process", "s");
    physicalProperties.put("laser", "s");
    physicalProperties.put("solution", "s");
    physicalProperties.put("lithography", "s");
    physicalProperties.put("self-assembly", "s");
    physicalProperties.put("photolithography", "s");
    physicalProperties.put("drying", "s");
    physicalProperties.put("etching", "s");
    physicalProperties.put("thermal", "s");
    physicalProperties.put("etched", "s");
    physicalProperties.put("angled", "s");
    physicalProperties.put("patterning", "s");
    physicalProperties.put("beam", "s");
    return physicalProperties;
  }
}