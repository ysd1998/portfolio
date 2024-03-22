package com.example.demo.config.loginsecurity;

//@Configuration
public class LoginAuthenticationProvider {//implements AuthenticationProvider {
//	@Autowired
//    private EmpLoginService userService;
//
//    @Override
//    public Authentication authenticate(Authentication auth) throws AuthenticationException {
//
//        LoginForm loginInfo = (LoginForm)auth.getPrincipal();
//        String password = (String)auth.getCredentials();
//
//        Collection<GrantedAuthority> authorityList = getAuthority(loginInfo);
//
//        if(authorityList.size() == 0) {
//            throw new BadCredentialsException("Authentication Error");
//        }
//
//        return new UsernamePasswordAuthenticationToken(loginInfo, password, authorityList);
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
//    }
//
//    private Collection<GrantedAuthority> getAuthority(LoginForm loginInfo) {
//        Collection<GrantedAuthority> authorityList = new ArrayList<>();
//
//        if(userService.login(loginInfo.getLoginId(), loginInfo.getPassword())) {
//            if (loginInfo.getAuthority().equals("管理者")) {
//                authorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//            } else if (loginInfo.getAuthority().equals("web販売担当")) {
//                authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
//            }
//        }
//
//        return authorityList;
//    }

}
