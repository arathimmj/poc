import { Component, OnInit } from '@angular/core';
import { Detail } from '../detail';
import { DetailService } from '../detail.service';
import * as fileSaver from 'file-saver';
import { HttpClient } from '@angular/common/http';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-new-cmp',
  templateUrl: './new-cmp.component.html',
  styleUrls: ['./new-cmp.component.css']
})
export class NewCmpComponent implements OnInit {
  selectedFiles: FileList;
  currentFileUpload: File;
  public detail = new Detail();
  fileUrl;

  constructor(private service: DetailService,private http: HttpClient,private sanitizer: DomSanitizer) { }

  ngOnInit() {
  }

  submit(){
    console.log(this.detail);
    this.service.postDetail(this.detail).subscribe(data => {
      console.log(data)
    })
  }

}