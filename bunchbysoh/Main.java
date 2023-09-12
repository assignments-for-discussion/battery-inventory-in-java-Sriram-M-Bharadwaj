package bunchbysoh;

public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  };

  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    CountsBySoH counts = new CountsBySoH();
    
        int [] stateofHealth = new int[presentCapacities.length];
        for(int i=0;i<presentCapacities.length;i++){
            if(presentCapacities[i]>120 || presentCapacities[i]<0){
           System.out.println(presentCapacities[i] + " is an invalid input");
                continue;
            }
            stateofHealth[i]= 100* presentCapacities[i]/120;
            if(stateofHealth[i]>=80)
                counts.healthy++;
            else if(stateofHealth[i]>=63)
                counts.exchange++;
            else counts.failed++;
        }

    return counts;
  }

  static void testBucketingByHealth() {
    System.out.println("Counting batteries by SoH...\n");
    int[] presentCapacities = {115, 118, 80, 95, 91, 72};
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    assert(counts.healthy == 2);
    assert(counts.exchange == 3);
    assert(counts.failed == 1);
    System.out.println("Done counting :)\n");
  }

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}
