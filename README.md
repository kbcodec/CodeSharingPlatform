# Code Sharing Platform
+++++++++++++++++++++++++
Click here to see my code
[CLICK](https://github.com/kbcodec/CodeSharingPlatform/tree/master/Code%20Sharing%20Platform/task/src)
+++++++++++++++++++++++++

## About project
Thanks to this program, the user can share his code with other users via the /code/new endpoint. In addition, the user can specify whether the code is to be hidden after a certain number of views or after a certain period of time. This code will be saved in the database.

Saved codes (if the restrictions have not been met) can be displayed in several ways:
- referring to a specific code uuid (code/{uuid})
- downloading content via JSON file (api/code/{uuid})
- displaying the last 10 added codes (only those that had no restrictions) via endpoints (code/latest) (api/code/latest)

## DEMO
### Adding new codes to the database
#### Via code/new 
![image](https://user-images.githubusercontent.com/103029426/232346173-201a9faa-60a2-449e-84fc-54a3b1794cd0.png)
![image](https://user-images.githubusercontent.com/103029426/232346343-274fb024-d8f0-4564-b64b-8ca708941a5f.png)
![image](https://user-images.githubusercontent.com/103029426/232346388-8b54c049-0dff-437a-9316-ed343568cb7d.png)
![image](https://user-images.githubusercontent.com/103029426/232346427-1d6322d6-0ed2-40b4-a744-55b9034a0628.png)

### Via api/code/new 
![image](https://user-images.githubusercontent.com/103029426/232347512-e4fefee6-ac4c-49b0-bb37-2a9400c64ccf.png)

### Listing specific code 
#### Via code/{uuid}
![image](https://user-images.githubusercontent.com/103029426/232347564-943c9678-9a62-4a28-b908-6e92462e5415.png)
![image](https://user-images.githubusercontent.com/103029426/232347588-d01a0c54-82eb-4614-80c9-62e2d7ce124d.png)
#### Via api/code/{uuid}
![image](https://user-images.githubusercontent.com/103029426/232347614-ab48c01e-3600-4dc2-a4d9-f4b573ce829c.png)

### Listing last 10 codes (without restrictions)
#### Via code/latest
![image](https://user-images.githubusercontent.com/103029426/232347658-be1c0826-79b0-4843-a383-85045ec6d71e.png)
#### Via api/code/latest
![image](https://user-images.githubusercontent.com/103029426/232347677-90291f03-b894-4d3d-9f7f-a52d0e5d258e.png)


