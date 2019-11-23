<?php
 
 include('dbConnect.php');

 $username = $_POST['username'];
 $email = $_POST['email'];
 $password =$_POST['password'];
 
if($username=="" && $email=="" && $password=="")
{
       echo '0';
}
else
{ 
  $sql = "INSERT INTO registration (username,email,password) VALUES ('$username','$email','$password')";
//echo $sql;
    $ex=mysqli_query($con,$sql);
    

}

 ?>