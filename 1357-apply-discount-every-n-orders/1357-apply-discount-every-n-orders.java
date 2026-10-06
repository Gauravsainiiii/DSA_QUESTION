class Cashier {
    private final int n;
    private final int discount;
    private final int[] pricesMap;
    private int customerCount;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        this.customerCount = 0;
        
        
        this.pricesMap = new int[201];
        for (int i = 0; i < products.length; i++) {
            this.pricesMap[products[i]] = prices[i];
        }
    }
    
    public double getBill(int[] product, int[] amount) {
        customerCount++;
        
        double total = 0;
        for (int i = 0; i < product.length; i++) {
            total += (double) pricesMap[product[i]] * amount[i];
        }
        
        
        if (customerCount % n == 0) {
            total = total * (100 - discount) / 100.0;
        }
        
        return total;
    }
}