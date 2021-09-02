import { element } from 'protractor';
import { environment } from './../../environments/environment.prod';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Publish } from '../model/Publish';
import { PublicarService } from '../service/publicar.service';

@Component({
  selector: 'app-menu-pagina-principal',
  templateUrl: './menu-pagina-principal.component.html',
  styleUrls: ['./menu-pagina-principal.component.css']
})
export class MenuPaginaPrincipalComponent implements OnInit {

  publish: Publish = new Publish();
  listaPublish: Publish[];

  // scripts do menu
  nome = environment.nome;
  foto = environment.foto;

  constructor(
    private router: Router,
    private publishService: PublicarService
  ) { }

  ngOnInit(): void {
    if (environment.token === '') {
      alert('Sua seçao expirou, faça o login novamente.');
      this.router.navigate(['/login']);
    }
    window.scroll(0, 0);
  }

  /* Sair das página */

  sair(): any {
    this.router.navigate(['/login']);
    environment.token = '';
    environment.nome = '';
    environment.foto = '';
    environment.id = 0;
  }

  menu(event: any): any {
    const menu = document.querySelector('#hamburger');
    const navigation = document.querySelector('.navigation');
    const content = document.querySelector('.content');

    menu?.classList.toggle('active');
    navigation?.classList.toggle('active');
    content?.classList.toggle('active');
  }

  /* SCRIPTS DA PARTE BOLETIM */

  cadastrar(): any {
    this.publishService.postPublish(this.publish).subscribe((resp: Publish) => {
      this.publish = resp;
      alert('Notas do aluno postado com sucesso!');
      this.publish = new Publish();
    });
  }

  modalBoletim(): any {
    const modal = document.querySelector('#modal-boletim');
    const close = document.querySelector('.fechar');
    modal?.classList.add('mostrar');
    modal?.addEventListener('click', (e) => {
      if (e.target === modal || e.target === close) {
        modal.classList.remove('mostrar');
      }
    });
  }

  /* MODAL VÍDEO */

  modalVideo(): any {
    const modal = document.querySelector('#modal-video');
    if (modal) {
      const close = document.querySelector('#close');
      modal?.classList.add('mostrar');
      modal?.addEventListener('click', (e) => {
        if (e.target === modal || e.target === close) {
          modal.classList.remove('mostrar');
        }
      });
    }
  }

  /* MODAL VÍDEO INFOR */

  modalInfo(): any {
    const modal = document.querySelector('#modal-info');
    if (modal) {
      const sumir = document.querySelector('#sumir');
      modal?.classList.add('mostrar');
      modal?.addEventListener('click', (e) => {
        if (e.target === modal || e.target === sumir) {
          modal.classList.remove('mostrar');
        }
      });
    }
  }

}
