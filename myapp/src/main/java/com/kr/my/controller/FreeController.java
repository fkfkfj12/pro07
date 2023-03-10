package com.kr.my.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kr.my.dto.FreeDTO;
import com.kr.my.service.FreeService;

@Controller
@RequestMapping("/free/*")
public class FreeController {

	@Autowired
	private FreeService freeService;
	
	@GetMapping("freeList")		//free/list.do
	public String getfreeList(Model model) throws Exception {
		List<FreeDTO> freeList = freeService.freeList(); 
		model.addAttribute("freeList", freeList);
		return "free/freeList";
	}
	
	@GetMapping("freeDetail")	//free/detail.do?bno=1
	public String getfreeDetail(HttpServletRequest request, Model model) throws Exception {
		int bno = Integer.parseInt(request.getParameter("bno"));
		FreeDTO dto = freeService.freeDetail(bno);
		model.addAttribute("dto", dto);
		return "free/freeDetail";
	}
	
	@GetMapping("freeInsert")
	public String insertForm(HttpServletRequest request, Model model) throws Exception {
		return "free/freeInsert";
	}
	
	@PostMapping("freeInsert")
	public String freeInsert(HttpServletRequest request, Model model) throws Exception {
		FreeDTO dto = new FreeDTO();
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		freeService.freeInsert(dto);
		
		return "redirect:freeList";
	}
	
	@GetMapping("freeDelete")
	public String freeDelete(HttpServletRequest request, Model model) throws Exception {
		int bno = Integer.parseInt(request.getParameter("bno"));
		freeService.freeDelete(bno);
		
		return "redirect:freeList";
	}
	
	@GetMapping("freeEdit.do")
	public String editForm(HttpServletRequest request, Model model) throws Exception {
		int bno = Integer.parseInt(request.getParameter("bno"));
		FreeDTO dto = freeService.freeDetail(bno);
		model.addAttribute("dto", dto);
		return "free/freeEdit";
	}
	
	@PostMapping("freeEdit")
	public String freeEdit(HttpServletRequest request, Model model) throws Exception {
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		FreeDTO dto = new FreeDTO();
		dto.setBno(bno);
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		freeService.freeEdit(dto);
		
		return "redirect:freeList";
	}
	
	@RequestMapping(value="/free/imageUpload.do", method = RequestMethod.POST)
    public void imageUpload(HttpServletRequest request,
            HttpServletResponse response, MultipartHttpServletRequest multiFile
            , @RequestParam MultipartFile upload) throws Exception{
        // ?????? ?????? ??????
        UUID uid = UUID.randomUUID();
        
        OutputStream out = null;
        PrintWriter printWriter = null;
        
        //?????????
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        try{
            
            //?????? ?????? ????????????
            String fileName = upload.getOriginalFilename();
            byte[] bytes = upload.getBytes();
            
            //????????? ?????? ??????
            String path = "D:\\jbj\\pro07\\src\\main\\webapp\\resources\\upload" + "ckImage/";
            String ckUploadPath = path + uid + "_" + fileName;
            File folder = new File(path);
            
            //?????? ???????????? ??????
            if(!folder.exists()){
                try{
                    folder.mkdirs(); // ?????? ??????
                }catch(Exception e){
                    e.getStackTrace();
                }
            }
            
            out = new FileOutputStream(new File(ckUploadPath));
            out.write(bytes);
            out.flush(); // outputStram??? ????????? ???????????? ???????????? ?????????
            
            String callback = request.getParameter("CKEditorFuncNum");
            printWriter = response.getWriter();
            String fileUrl = "/free/ckImgSubmit.do?uid=" + uid + "&fileName=" + fileName;  // ????????????
            
        // ???????????? ????????? ??????
          printWriter.println("{\"filename\" : \""+fileName+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}");
          printWriter.flush();
            
        }catch(IOException e){
            e.printStackTrace();
        } finally {
          try {
           if(out != null) { out.close(); }
           if(printWriter != null) { printWriter.close(); }
          } catch(IOException e) { e.printStackTrace(); }
         }
        
        return;
    }
	
	/**
     * cKeditor ????????? ????????? ????????? ????????????
     * @param uid
     * @param fileName
     * @param request
     * @return
     * @throws ServletException
     * @throws IOException
     */
    //
    @RequestMapping(value="/free/ckImgSubmit.do")
    public void ckSubmit(@RequestParam(value="uid") String uid
                            , @RequestParam(value="fileName") String fileName
                            , HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException{
        
        //????????? ????????? ????????? ??????
        String path = fileDir.getPath() + "ckImage/";
    
        String sDirPath = path + uid + "_" + fileName;
    
        File imgFile = new File(sDirPath);
        
        //?????? ????????? ?????? ????????? ?????? ??????????????? ??? ????????? ????????? ????????????.
        if(imgFile.isFile()){
            byte[] buf = new byte[1024];
            int readByte = 0;
            int length = 0;
            byte[] imgBuf = null;
            
            FileInputStream fileInputStream = null;
            ByteArrayOutputStream outputStream = null;
            ServletOutputStream out = null;
            
            try{
                fileInputStream = new FileInputStream(imgFile);
                outputStream = new ByteArrayOutputStream();
                out = response.getOutputStream();
                
                while((readByte = fileInputStream.read(buf)) != -1){
                    outputStream.write(buf, 0, readByte);
                }
                
                imgBuf = outputStream.toByteArray();
                length = imgBuf.length;
                out.write(imgBuf, 0, length);
                out.flush();
                
            }catch(IOException e){
                logger.info(e);
            }finally {
                outputStream.close;
                fileInputStream.close;
                out.close;
            }
        }
    }