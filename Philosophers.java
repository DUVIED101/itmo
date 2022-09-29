class DiningPhilosophers {

    Semaphore[] f = new Semaphore[5];
        
    public DiningPhilosophers() {
        for(int i = 0; i<5; i++) {
        f[i] = new Semaphore(1);
        }        
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        {
         if (philosopher % 2 == 0){
            synchronized(f[philosopher]){
                synchronized(f[(philosopher+1)%5]){
        pickLeftFork.run();
        pickRightFork.run();
        
        eat.run();
        
        putLeftFork.run();
        putRightFork.run();   
            }
            }
         }
         else{
            synchronized(f[(philosopher+1)%5]){
                synchronized(f[philosopher]){
        pickLeftFork.run();
        pickRightFork.run();
        
        eat.run();
        
        putLeftFork.run();
        putRightFork.run();
                }
            } 

         }
           
        }
   
    }
}
