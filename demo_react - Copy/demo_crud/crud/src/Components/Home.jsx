// import logo from './logo.svg';

import { useState, useEffect } from'react';
import axios  from 'axios';
import '../Styles/home.css';
import { Link, useNavigate, useParams } from 'react-router-dom';



function Home() {

let[data, setData]=useState(null);
let navigate = useNavigate();
  
// useEffect(()=>{
//   fetch("http://localhost:8080/employee/getall")
//   .then((res)=>{console.log(res); return res.json()})
//   .then((data)=>{ console.log(data); setData(data); })

// },[])

useEffect(()=>{
  axios.get("http://localhost:8080/employee/getall")
  .then((response)=>{ console.log(response.data); setData(response.data)})
  .catch((error)=>{ console.log(error)});
},[])


/////////////////////////////////
//Delete Operation
let handleDelete=(id)=>{
  console.log("id");
  console.log(id);
  // Delete operation
  axios.delete("http://localhost:8080/employee/deletebyid/"+id)
  .then((res)=>{alert(" Data has been removed successfully"); console.log(res+" Data has been removed successfully");
  window.location.reload();
  navigate("/")})
  .catch((err)=>{console.log(err);})
}

let {id} = useParams();
console.log(id);

//////////////////////////////////
  return (
    <div className="App">
      <nav className="nav">

      <div className="sch">
      <input className="search" type="search" name="" id="" /><button className="srch" type="submit">Search</button>
      </div>
       
      </nav>

      <table border="2px">
      
        <thead>
          <th>Id</th>
          <th>NAME</th>
          <th>Age</th>
          <th>Gender</th>
          <th>Location</th>
          <th>Salary</th>
          <th>Choose to delete</th>
          <th>Choose to Update</th>
        </thead>
     {data && data.map((v)=>{

      return (
        <>
        <tr>
        
          <td>{v.id}</td>
          <td>{v.name}</td>
          <td>{v.age}</td>
          <td>{v.gender}</td>
          <td>{v.location}</td>
          <td>{v.salary}</td>
          <td><button className="btn" onClick={()=>handleDelete(v.id)}>Delete</button></td>
          <td><Link to={"/update/"+v.id}><button className="btn1">Update</button></Link>
          </td>
          
        </tr>
        
       <br />
        
        </>
      );
     })}

</table>
    
<Link to="/add"><button className="button">Add</button></Link> 
     
    </div>
  );
}

export default Home;