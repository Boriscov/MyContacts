import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewContact2Component } from './new-contact2.component';

describe('NewContact2Component', () => {
  let component: NewContact2Component;
  let fixture: ComponentFixture<NewContact2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewContact2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewContact2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
