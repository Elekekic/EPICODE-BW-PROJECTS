import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Fatture } from 'src/app/interfaces/fatture';
import { FattureService } from 'src/app/services/fatture.service';

@Component({
  selector: 'app-fatture-cliente',
  templateUrl: './fatture-cliente.component.html',
  styleUrls: ['./fatture-cliente.component.scss'],
})
export class FattureClienteComponent implements OnInit {
  fatture: Fatture[] = [];

  constructor(
    private fattureSrv: FattureService,
    private router: ActivatedRoute
  ) {}

  async ngOnInit(): Promise<void> {
    this.router.params.subscribe(async (params) => {
      const id = +params['id'];
      this.fattureSrv
        .getFattureByClienteId(id)
        .subscribe((data) => {this.fatture = data;
           console.log(this.fatture)
        })
    });
  }
}
