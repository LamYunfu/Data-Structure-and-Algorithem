package com.ouc.algorithm.CodingInterviewGuidePartOne;

import java.util.LinkedList;
import java.util.Queue;

public class PartOne010 {
	/**
	 * �������һ���ܵĶ����������е�ʵ�������в���
	 * �����ڵ����ض�Cat����Dog���г��Ӳ���ʱ�Ὣ������DogҲpop��
	 * ���ֻ���������������Dog��Cat����
	 * ��������һ��ȫ�ֱ��������ÿһ������еĶ�����ȫ���µ�ʱ���
	 * ���ǲ��ܸ�дԭ�е�Cat��Dog�࣬���Կ����½�һ���µ��࣬ʵ��override
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
		 * ��ԭ�е����������½���һ����
		 * 1.������ʱ�����������¼ÿ�����������е�ʱ��
		 * 2.����������Pet,�ø�������������������ʵ��
		 * @author ���Ƹ�
		 *
		 */
		class PetEnterQueue{
			private Pet pet;
			private long count;				//��¼�����ܶ��е�λ��
			
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
		//peek�������ص��ǲ��Ƴ���е�ͷ
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
