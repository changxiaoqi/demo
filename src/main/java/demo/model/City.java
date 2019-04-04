package demo.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * POJO:City
 * 
 * @author duia_builder
 * @date 2018-3-8
 */
@Table(name = "City")
@Entity
public class City  {
	
	private Long id;
	private Long	parentId;		 /* 上级城市ID */ 
	private String	name;		 /* 省份／尘世名称 */ 
	private String	spelling;		 /* 拼音 */ 
	private String	jianpin;		 /* 简拼 */ 
	private Integer	level;		 /* 等级 */ 
	private Integer	sort;		 /* 排序 */ 
	private Date	createTime;		 /* 录入时间 */ 
	private Integer	status;		 /* 启用状态 0 未启用 1 启用 */ 

	// getter && setter
	// 在setter方法最后加上"return this;"并把返回参数改为City可以实现连缀设置属性

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public City setParentId(Long parentId) {
		this.parentId = parentId;
		return this;
	}
	
	
	public String getName() {
		return name;
	}

	public City setName(String name) {
		this.name = name;
		return this;
	}
	
	
	public String getSpelling() {
		return spelling;
	}

	public City setSpelling(String spelling) {
		this.spelling = spelling;
		return this;
	}
	
	
	public String getJianpin() {
		return jianpin;
	}

	public City setJianpin(String jianpin) {
		this.jianpin = jianpin;
		return this;
	}
	
	
	public Integer getLevel() {
		return level;
	}

	public City setLevel(Integer level) {
		this.level = level;
		return this;
	}
	
	
	public Integer getSort() {
		return sort;
	}

	public City setSort(Integer sort) {
		this.sort = sort;
		return this;
	}
	
	public Date getCreateTime() {
		return createTime;
	}

	public City setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
	
	
	public Integer getStatus() {
		return status;
	}

	public City setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	@Override
	public String toString() {
		return "City [" + "id=" + getId() + ", parentId=" + parentId + ", name=" + name + ", spelling=" + spelling + ", jianpin=" + jianpin + ", level=" + level + ", sort=" + sort + ", createTime=" + createTime + ", status=" + status +  "]";
	}
}
