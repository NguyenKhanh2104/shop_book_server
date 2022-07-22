package com.example.api_shop_book.controllers;

import com.example.api_shop_book.helper.UserHelper;
import com.example.api_shop_book.model.User;
import com.example.api_shop_book.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/test")
public class TestController {
	@Autowired
	private final UserHelper userHelper;
//	@Autowired
//	private final StaffHelper staffHelper;
	@Autowired
	private UserService userService;
//	@Autowired
//	private StaffService staffService;

	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
//
	@GetMapping("/user")
	public ResponseEntity<?> getAllUser(){
		return userHelper.getAllUser();
	}

//	@PostMapping("/addUser")
//	@RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@PostMapping(value = "/addUser", consumes={"application/json"})
	public ResponseEntity<?> createUser(@Valid @RequestBody User user){

		return userHelper.createUser(user);
	}

	@GetMapping("/findUserId/{id}")
//	@GetMapping("/findUserId")
	public ResponseEntity<?> getUserId(@PathVariable(value = "id") Integer userId) throws Exception {
		return userHelper.findId(userId);
	}

	@PutMapping("/updateUser/{id}")
	public ResponseEntity<?> updateUser(@PathVariable(value = "id") Integer userId,
										@Valid @RequestBody User userDetail) throws Exception {
		System.out.println(userDetail.getFullname());
		return userHelper.updateUser(userId, userDetail);
	}

//	@DeleteMapping("/deleteUser/{id}")
//	@DeleteMapping("/deleteUser")
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable(value = "id") Integer userId){
		userHelper.deteleUser(userId);
	}

	@GetMapping("/mod")
//	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}





//
//
//	@GetMapping("/staff")
//	public ResponseEntity<?> getAllStaff(){
//		return staffHelper.getAllStaff();
//	}
//
//	@PostMapping("/addStaff")
//	public ResponseEntity<?> createStaff(@Valid @RequestBody Staff staff){
//		return staffHelper.createStaff(staff);
//	}
//
//	//	@GetMapping("/findUserId/{id}")
//	@GetMapping("/findStaffId")
//	public ResponseEntity<?> getStaffId(@PathVariable(value = "id") Integer staffId) throws Exception {
//		return staffHelper.findId(staffId);
//	}
//
//	@PutMapping("/updateStaff/{id}")
//	public ResponseEntity<?> updateStaff(@PathVariable(value = "id") Integer staffId) throws Exception {
//		return staffHelper.updateStaff(staffId);
//	}
//
//	//	@DeleteMapping("/deleteUser/{id}")
////	@DeleteMapping("/deleteUser")
//	@CrossOrigin(origins = "http://localhost:4200")
//	@DeleteMapping("/deleteStaff/{id}")
//	public void deleteStaff(@PathVariable(value = "id") Integer staffId){
//		staffHelper.deteleStaff(staffId);
//	}



}
