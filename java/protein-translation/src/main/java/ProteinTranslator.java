import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ProteinTranslator {

    static final Map<String, String> rnaMap = new HashMap<>() {{
        put("AUG", "Methionine");
        put("UUU", "Phenylalanine");
        put("UUC", "Phenylalanine");
        put("UUA", "Leucine");
        put("UUG", "Leucine");
        put("UCU", "Serine");
        put("UCC", "Serine");
        put("UCA", "Serine");
        put("UCG", "Serine");
        put("UAU", "Tyrosine");
        put("UAC", "Tyrosine");
        put("UGU", "Cysteine");
        put("UGC", "Cysteine");
        put("UGG", "Tryptophan");
        put("UAA", "STOP");
        put("UAG", "STOP");
        put("UGA", "STOP");
    }};

    public ProteinTranslator() {

    }

    List<String> translate(String rnaSequence) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < rnaSequence.length(); i += 3) {
            var rna = rnaSequence.charAt(i) + "" + rnaSequence.charAt(i + 1) + "" + rnaSequence.charAt(i + 2);
            if (rnaMap.get(rna)
              .equals("STOP")) {
                break;
            }
            result.add(rnaMap.get(rna));
        }
        return result;
    }
}
