package com.ouc.algorithm.CodingInterviewGuidePartOne;

import java.util.LinkedList;
import java.util.Queue;

public class PartOne010 {
	/**
	 * 不能设计一个总的队列来对所有的实例来进行操作
	 * 这样在单独地对Cat或者Dog进行出队操作时会将其它的Dog也pop出
	 * 因此只能设计两个单独的Dog和Cat队列
	 * 并且设置一个全局变量来标记每一个入队列的对象在全局下的时间戳
	 * 但是不能改写原有的Cat和Dog类，所以可以新建一个新的类，实现override
	 * @param args
	 */
	class Pet{
		private String type;
			
		public Pet(String type){
			this.type = type;
		}
			
		public String getPetType(){
				return this.type;
		}
	}
		
		class Dog extends Pet{
			public Dog(String type){
				super(type);
			}
		}
		
		class Cat extends Pet{
			public Cat(String type){
				super(type);
			}
		}
		/**
		 * 在原有的数据上面新建的一个类
		 * 1.增加了时间戳，用来记录每个对象进入队列的时间
		 * 2.参数类型是Pet,用父类的类型来接收子类的实例
		 * @author 蓝云甫
		 *
		 */
		class PetEnterQueue{
			private Pet pet;
			private long count;				//记录它在总队列的位置
			
			public PetEnterQueue(Pet pet, long count){
				this.pet = pet;
				this.count = count;
			}
			
			public Pet getPet(){
				return this.pet;
			}
			
			public String getPetType(){
				return this.pet.getPetType();
			}
			
			public long getCount(){
				return this.count;
			}
		}
		
	private Queue<PetEnterQueue> dogQ;
	private Queue<PetEnterQueue> catQ;
	private long count;
	
	public PartOne010(){
		this.dogQ = new LinkedList<PetEnterQueue>();
		this.catQ = new LinkedList<PetEnterQueue>();
		this.count = 0;
	}
	
	public void add(Pet pet){
		if(pet.getPetType().equals("dog")){
			dogQ.add(new PetEnterQueue(pet, this.count++));
		}
		else if(pet.getPetType().equals("cat")){
			catQ.add(new PetEnterQueue(pet, this.count++));
		}
		else{
			throw new RuntimeException("erro, this is no dog or cat");
		}
	}
	
	public Pet pollAll(){
		//peek方法返回但是不移除隊列的头
		if(!this.dogQ.isEmpty() && !this.catQ.isEmpty()){
			if(this.dogQ.peek().getCount() > this.catQ.peek().getCount()){
				return this.dogQ.poll().getPet();
			}
			else{
				return this.catQ.poll().getPet();
			}
		}
		else if(!this.dogQ.isEmpty()){
			return this.dogQ.poll().getPet();
		}
		else if(!this.catQ.isEmpty()){
			return this.catQ.poll().getPet();
		}
		else{
			throw new RuntimeException("Erro, queue is Empty");
		}
	}
	
	public Dog pollDog(){
		if(!this.dogQ.isEmpty()){
			return (Dog)this.dogQ.poll().getPet();
		}
		else{
			throw new RuntimeException("Error, the Queue is Empty");
		}
	}
	
	public Cat pollCat(){
		if(!this.catQ.isEmpty()){
			return (Cat)this.catQ.poll().getPet();
		}
		else{
			throw new RuntimeException("Error, the Queue is Empty");
		}
	}
}
