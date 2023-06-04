import qs from 'qs';
import React, { useRef} from'react';
import axios from'axios';
import '../Styles/add.css';
import { useNavigate, useParams } from 'react-router-dom';


function Add() {

    let navigate = useNavigate();
   
    let name = useRef();
    let age = useRef();
    let location = useRef();
    let gender = useRef();
    let salary = useRef();
    
    

    let submitHandler=(e)=>{
        e.preventDefault();
        
        let add = {
            name: name.current.value,
            age: age.current.value,
            location : location.current.value,
            gender : gender.current.value,
            salary: salary.current.value
          }

        axios("http://localhost:8080/employee/add",{
                method:"POST",
                headers:{   "Content-type":"application/json"   },
                data:add,
                body:JSON.stringify(add)
            }).then((res)=>{
                        console.log(res); 
                        alert("Noworries Madam! Data has been added.!"); 
                        navigate("/");
                        })
        .catch((err)=>{console.log(err);})
    }

    return ( 
        <>
        <form onSubmit={submitHandler}>
        
        <label>Name : </label>
            <input type="text"   placeholder="Name" ref={name} required/>
        <label>Age : </label>
            <input type="number"  placeholder="Age" ref={age} required/>
        <label>Location : </label>
            <input type="text"  placeholder="location" ref={location} required/>
        <label>Gender : </label>
            <input type="text"  placeholder="gender" ref={gender} required/>
        <label>Salary : </label>
            <input type="number" placeholder="Salary" ref={salary}/>
       <input type="submit"/>
        </form>
        </>
     );
}

export default Add;