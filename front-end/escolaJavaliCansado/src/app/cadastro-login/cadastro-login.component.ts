import { environment } from './../../environments/environment.prod';

import { UserLogin } from './../model/UserLogin';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/User';
import { AuthService } from '../service/auth.service';

@Component
({
  selector: 'app-cadastro-login',
  templateUrl: './cadastro-login.component.html',
  styleUrls: ['./cadastro-login.component.css']
})
export class CadastroLoginComponent implements OnInit {
  /*========== cadastro ==========*/
  user: User = new User();
  confirmarSenha: string;
  tipoUsuario: string;
  /*========== /cadastro ==========*/

  /*========== Login ==========*/
  userLogin: UserLogin = new UserLogin();
  /*========== /Login ==========*/

  constructor(
    private authService: AuthService,
    private router: Router
  ) {}

  classLogin = '0';

  classCadastro = '0';

  classBtn = '0';

  ngOnInit(): void {
    window.scroll(0, 0);
  }

  confirmSenha(event: any): void {
    this.confirmarSenha = event.target.value;
  }

  tipoUser(event: any): void {
    this.tipoUsuario = event.target.value;
  }

  /*================== Script do buttons de deslizar do cadastro ==================*/

  mudaLogin(): void {
    this.classLogin = 'left50';
    this.classCadastro = 'left450';
    this.classBtn = 'left0';
  }

  mudaCadastro(): void {
    this.classLogin = 'leftMenos400';
    this.classCadastro = 'marginLeft50';
    this.classBtn = 'left110';
  }

  login(): void {
    this.authService.login(this.userLogin).subscribe((resposta: UserLogin) => {
      this.userLogin = resposta;

      environment.token = this.userLogin.token;
      environment.nome = this.userLogin.nome;
      environment.foto = this.userLogin.foto;
      environment.id = this.userLogin.idUser;
      console.log(environment.nome);
      this.router.navigate(['/menu-pagina-principal']);
    }, erro => {
      if (erro.status === 500) {
        alert('E-mail ou senha estão incorretos!');
      }
    });
  }

  cadastrar(): void {
    this.user.tipo = this.tipoUsuario;
    if (this.user.senha !== this.confirmarSenha) {
      alert('As senhas estão incorretas');
    } else {
      this.authService.cadastro(this.user).subscribe((resp: User) => {
        this.user = resp;
        this.router.navigate(['/login']);
        alert('Usuário cadastrado com sucesso!');
      });
    }
  }
}
