import { element } from 'protractor';
import { environment } from './../../environments/environment.prod';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu-pagina-principal',
  templateUrl: './menu-pagina-principal.component.html',
  styleUrls: ['./menu-pagina-principal.component.css']
})
export class MenuPaginaPrincipalComponent implements OnInit {

  // scripts do menu
  nome = environment.nome;
  foto = environment.foto;
  navigation: any;
  corpo: any;
  toogle: any;
  content: any;

  constructor(
    private router: Router
  ) { }

  ngOnInit(): void {
    /*
    if (environment.token === '') {
      alert('Sua seçao expirou, faça o login novamente.');
      this.router.navigate(['/login']);
    }
    */
    window.scroll(0, 0);
  }

  /* Sair das página
  sair(): any {
    this.router.navigate(['/login']);
    environment.token = '';
    environment.nome = '';
    environment.foto = '';
    environment.id = 0;
  }

  toggle(): any {
    this.menu.classList.toogle('active');
    this.navigation.classList.toogle('active');
    this.corpo.classList.toggle('active');
    console.log(this.menu);
  }
  */

  menu(event: any): any {
    const menu = document.querySelector('#hamburger');
    const navigation = document.querySelector('.navigation');
    const content = document.querySelector('.content');

    menu?.classList.toggle('active');
    navigation?.classList.toggle('active');
    content?.classList.toggle('active');
  }
}
