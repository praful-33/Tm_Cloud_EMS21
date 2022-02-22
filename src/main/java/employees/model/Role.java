package employees.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.Data;

@Data
@Entity(name="role")
@Table(name="role")
public class Role{
	@Column(name = "role_id", nullable = false,columnDefinition = "int default 0" )
	@Id private int role_id;
	
	@Column(name = "role", nullable = false)
	private String role;
	
}
