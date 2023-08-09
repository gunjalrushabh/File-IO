# File-IO
File_IO_1
Springboot + Oracle
1. Upload and download
2. download by id (You must know file id) ------ optional in future it will change


Modification in File_IO_2
1. Adding Fields created_at, modified_at, Status, etc
2. file download by path

Modification in File_IO_3
1. Now if we store all files in database then database gets heavy , now i am storing **FILE path** while uploading file
   **POST REQUEST**
   URI LIKE : http://localhost:8083/folder
   FILE_ID : 83
   CREATED_AT : 08-AUG-23
   FILE_NAME : 2023-08-08$$new
   FILE_TYPE : text.txt	text/plain
   MODIFIED_AT : 08-AUG-23
   STATUS : file uploaded  at: 2023-08-08
   FILE_UUID : 0618c1d2-a4f8-4cda-a89a-98bc52f22cbf
   FILE_PATH : C:\Rushabh 19\github upload\File-IO\File_io2\target\classes\static\2023\8\8\new text.txt

3. While downloading file by taking UUID of that file
   **GET REQUEST**
   URI LIKE : http://localhost:8083/filesystem/FILE_UUID
   Example : http://localhost:8083/filesystem/0618c1d2-a4f8-4cda-a89a-98bc52f22cbf
   your file fetch from filesystem via uuid and shows on browser
   
