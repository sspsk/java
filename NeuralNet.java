
class Perseptron{
  float[] weights  = new float[2];
  Perseptron(){
    for(int i=0;i<weights.length;i++){
      weights[i] = (float)(Math.random()*Math.pow(-1,(((int)(Math.random()*10))%2)));
    }
  }
  int guess(float[] inputs){
    float result=0;
    for(int i=0;i<inputs.length;i++){
      result += inputs[i]*weights[i];
    }
    if(result >= 0)return 1;
    else return -1;
  }
  void train(float[] inputs,int label){
    int guess = guess(inputs);
    int error = label-guess;
    for(int i=0;i<weights.length;i++){
      weights[i] += error*inputs[i]*0.1;
    }

  }

}
class Point{
  float x,y;
  int label;
  Point(){
    x = (float)Math.random()*100;
    y = (float)Math.random()*100;
    if(x>y)label = 1;
    else label = -1;
  }
}




public class NeuralNet{
  public static void main(String[] args){
    Perseptron per = new Perseptron();
    Point[] trainData= new Point[1000000];
    for(int i=0;i<trainData.length;i++){
      trainData[i] = new Point();
      float[] inputs = {trainData[i].x,trainData[i].y};
      per.train(inputs,trainData[i].label);
      }
    Point[] testPoint = new Point[100];
    int counter=0;
    for(int i = 0;i<testPoint.length;i++){
      testPoint[i] = new Point();
      float[] data = {testPoint[i].x,testPoint[i].y};
      int guess = per.guess(data);
      if(guess == testPoint[i].label)counter++;
    }
    System.out.println("statistics: "+counter+"%");

  }
}
