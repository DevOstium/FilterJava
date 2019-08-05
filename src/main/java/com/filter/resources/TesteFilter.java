package com.filter.resources;

import org.aspectj.apache.bcel.classfile.Module.Require;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import net.bytebuddy.implementation.bytecode.constant.DefaultValue;

@RestController
@RequestMapping(value= "/teste-filter")
public class TesteFilter {
	
	//localhost:8080/teste-filter?id=45&token=ererere
	@GetMapping
	public String testeFilter( 
			                     @RequestParam(value="token", required = false, defaultValue = "" ) String token
			                    ,@RequestParam(value="id"   , required = false, defaultValue = "" ) String id
			                   	 //@PathVariable(value="id")    String id
			                    //,@PathVariable(value="token") String token
			                   ) {
		
		return "Dados dos Filter - Novo : " + token + " id : " + id;
		//return "Dados dos Filter - Novo : " + " id : " + id;
	}

}