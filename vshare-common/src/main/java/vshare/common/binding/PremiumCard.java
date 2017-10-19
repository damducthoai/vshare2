package vshare.common.binding;

import java.util.HashMap;
import java.util.Map;

public class PremiumCard {
    public static final String STATUS_AVAILABLE = "AVAILABLE";
    public static final String STATUS_USED = "USED";
    public static final Map<Long, String> CARD_TYPES = new HashMap<>();
    public static PremiumCard ourInstance = new PremiumCard();

    private PremiumCard() {
    }

    public static PremiumCard getInstance() {
        return ourInstance;
    }

    public void postInit() {
        CARD_TYPES.put(Long.valueOf(10000), "10K CARD");
        CARD_TYPES.put(Long.valueOf(20000), "20K CARD");
        CARD_TYPES.put(Long.valueOf(50000), "50K CARD");
    }
}
