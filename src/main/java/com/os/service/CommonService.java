package com.os.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.mapper.CommonMapper;
import com.os.mapper.ImageMapper;
import com.os.model.BannerImage;
import com.os.model.City;
import com.os.model.Feedback;
import com.os.model.Group;
import com.os.model.Image;
import com.os.model.JobType;
import com.os.model.Province;
import com.os.model.WalletBankcardType;

@Service
public class CommonService {
	
	@Autowired
	private CommonMapper commonMapper;
	@Autowired
	private ImageMapper workMapper;
	
	public void saveImage(Image image){
		workMapper.insert(image);
	}
	
	public void saveFiles(List<Image> images){
		for(Image work: images){
			saveImage(work);
		}
	}
	
	public List<JobType> getJobTypeList(){
		return commonMapper.jobTypeList();
	}
	
	public List<Group> getGroupList(){
		return commonMapper.groupList();
	}
	
	public List<City> getCityList(){
		return commonMapper.cityList();
	}
	
	public List<City> getCityList(int provinceId){
		return commonMapper.cityListByProvinceId(provinceId);
	}
	
	public List<Province> getProvinceList(){
		return commonMapper.provinceList();
	}
	
	public List<BannerImage> getBannerImageList(){
		return commonMapper.bannerImageList();
	}
	
	public List<WalletBankcardType> getBankcardTypeList(String prefix){
		return commonMapper.bankcardTypeList(prefix);
	}
	
	public int feedbackAdd(Feedback feedback){
		return commonMapper.feedbackAdd(feedback);
	}
}
