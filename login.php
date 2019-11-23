<?php
include 'dbConnect.php';

$unm=$_REQUEST["uname"];
$pwd=$_REQUEST["pass"];

//$sel="select * from registration where  username='$unm' and password='$pwd'";
$sel="select * from registration where  username='$unm' and password = '$pwd'";
$ex=mysqli_query($con,$sel);
$no=mysqli_num_rows($ex);
//echo $no;


if($no>0)
{
$fet=mysqli_fetch_object($ex);
echo json_encode($fet);
}
else
{
echo "0";
}


?>